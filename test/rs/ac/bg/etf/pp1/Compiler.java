package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;

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

			log.info("====================SEMANTIC ANALYSIS========================");
			SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
			program.traverseBottomUp(semanticAnalyzer);

			log.info("=====================SYNTAX ANALYSIS=========================");
			log.info((semanticAnalyzer.mainFound ? 1 : 0) + " methods in the program");
			log.info(semanticAnalyzer.constVariableDeclared + " constants declared");
			log.info(semanticAnalyzer.globalVariablesDeclared + " global variables declared");
			log.info(semanticAnalyzer.globalArraysDeclared + " global arrays declared");
			log.info(semanticAnalyzer.localVariablesDeclared + " local variables declared");
			log.info(semanticAnalyzer.localArraysDeclared + " local arrays declared");
			log.info(semanticAnalyzer.statementsInMain + " statements in main");

			SymTab.dump();

			if (!parser.errorDetected && semanticAnalyzer.passed())
			{
				log.info("=============PARSING FINISHED SUCCESSFULLY=================");
			}
			else
			{
				log.error("============PARSING FINISHED UNSUCCESSFULLY================");
			}
		} 
		finally
		{
			if (bufferReader != null) try { bufferReader.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}
	}
}
