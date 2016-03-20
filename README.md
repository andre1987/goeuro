# goeuro
This is a small project that contains tests for search result page of goeuro.com

Supported operating systems are: **Windows** and **Linux**.

Supported browsers are: **Chrome**, **Firefox** and **Phantomjs**.

To run tests:
mvn clean install -Plocal -Dos=windows|linux -Dbrowser=chrome|firefox|phantomjs

Run the following command to generate javadoc for test classes:
mvn javadoc:test-javadoc
