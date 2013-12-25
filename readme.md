pdfgen сервлет который разварачивается под апачем который на входе ждёт 2 файлика - XML с данными и XSLT с разметкой
и выдаёт PDF
основано это всё на Apache FOP:
http://xmlgraphics.apache.org/fop/


исходник - pdfgen.java
откомпиленый класс pdfgen.class
и собстно полностью веб приложение/сервлет - pdfgen.war его просто нужно в папку webapps у tomcat закинуть и он сам развернётся,
то есть для примера(в моём случае) покласть вот сюда:
C:\Program Files (x86)\Apache Software Foundation\Tomcat 6.0\webapps\
и после этого pdfgen будет доступен по адресу:
http://localhost:8080/pdfgen/
у этого сервлета один метод - makePDF:
http://localhost:8080/pdfgen/makePDF
то есть фактически нужно оправлять вот такую форму:
<form name="formname" action="http://localhost:8080/pdfgen/makePDF" method="post"  enctype="multipart/form-data">
<input type="file" name="xml" />
<input type="file" name="xslt" />
</form>
и на выходе будет PDF файл


1.html простой пример как это всё работает - нужно выбрать xml файл и xslt и запостить их и на выходе получим PDF
тут же лежат файлы 1.xml и 1.xslt которые как раз можно передать в качестве примера

compile.bat батник который компилит :) но там всё уже от окружения и путей зависит, надо править под свою машину