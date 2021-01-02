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
		
		Reader br = null;
		try
		{
			File sourceCode = new File("test/program.mj");
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			
			MJParser parser = new MJParser(lexer);
	        Symbol symbol = parser.parse();
	        
	        Program program = (Program)(symbol.value);
	        SymTab.init();

			log.info(program.toString(""));
			log.info("===================================");


			SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
			program.traverseBottomUp(semanticAnalyzer);

			SymTab.dump();

			if (!parser.errorDetected && semanticAnalyzer.passed())
			{
				log.info("Parsing finished SUCCESSFULLY!");
			}
			else
			{
				log.error("Parsing finished UNSUCCESSFULLY!");
			}
		} 
		finally
		{
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}
	}
}
