javac -classpath .;.\WEB-INF\lib\fop.jar;.\WEB-INF\lib\xmlgraphics-commons-1.5.jar;.\WEB-INF\lib\xml-apis-1.3.04.jar;.\WEB-INF\lib\xalan-2.7.0.jar;"C:\Program Files (x86)\Apache Software Foundation\Tomcat 6.0\lib\servlet-api.jar";"C:\Program Files (x86)\Apache Software Foundation\Tomcat 6.0\lib\tomcat-coyote.jar" pdfgen.java
copy pdfgen.class .\WEB-INF\classes
jar cvf pdfgen.war WEB-INF