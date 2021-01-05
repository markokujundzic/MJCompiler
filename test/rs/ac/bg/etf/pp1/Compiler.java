package rs.ac.bg.etf.pp1;

import java.io.*;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;

public class Compiler
{

	static
	{
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws Exception
	{
		Logger log = Logger.getLogger(Compiler.class);
		Reader bufferReader = null;

		try
		{
			File sourceCode = new File("test/program.mj");

			log.info("====================LEXICAL ANALYSIS========================");
			bufferReader = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(bufferReader);
			
			MJParser parser = new MJParser(lexer);
	        Symbol symbol = parser.parse();

			Program program = (Program)(symbol.value);

			SymTab.init();

			log.info("=======================SYNTAX TREE===========================");
			log.info(program.toString(""));

	        if (!parser.errorDetected)
			{
				log.info("======================SEMANTIC ANALYSIS======================");
				SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
				program.traverseBottomUp(semanticAnalyzer);

				log.info("=======================SYNTAX ANALYSIS=======================");
				log.info((semanticAnalyzer.isMainFound() ? 1 : 0) + " methods in the program");
				log.info(semanticAnalyzer.getConstVariableDeclared() + " constants declared");
				log.info(semanticAnalyzer.getGlobalVariablesDeclared() + " global variables declared");
				log.info(semanticAnalyzer.getGlobalArraysDeclared() + " global arrays declared");
				log.info(semanticAnalyzer.getLocalVariablesDeclared() + " local variables declared");
				log.info(semanticAnalyzer.getLocalArraysDeclared() + " local arrays declared");
				log.info(semanticAnalyzer.getStatementsInMain() + " statements in main");

				SymTab.dump();

				if (!semanticAnalyzer.passed())
				{
					log.info("===========ERROR ENCOUNTERED IN SEMANTIC ANALYSIS===========");
				}
				else
				{
					log.info("================SEMANTIC ANALYSIS SUCCESSFUL================");

					File objectFile = new File("test/program.obj");

					if (objectFile.exists())
					{
						objectFile.delete();
					}

					CodeGenerator codeGenerator = new CodeGenerator();
					program.traverseBottomUp(codeGenerator);

					Code.dataSize = semanticAnalyzer.getnVars();
					Code.mainPc = codeGenerator.getMainPC();
					Code.write(new FileOutputStream(objectFile));

					log.info("==============COMPILATION FINISHED SUCCESSFULLY==============");
				}
			}
	        else
			{
				log.error("==============ERROR ENCOUNTERED WHILE PARSING==================");
			}
		} 
		finally
		{
			if (bufferReader != null) try { bufferReader.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}
	}
}
