### Execute Tests
`mvn clean test -Dsuite.name=${suiteName from src/test/resources} -Dbrowser=chrome|firefox`

### Generate Allure report
`mvn site`
