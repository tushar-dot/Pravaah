"# Pravaah" 
curl  - create case
curl --location 'http://localhost:8080/case/create-case' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzYW55YXNpbmdoQGdtYWlsLmNvbSIsImlhdCI6MTc2ODMyMjAzNSwiZXhwIjoxNzY4MzI1NjM1fQ.H4lGW43VYgT-2oMk9UJNiZofLnaqLKz8hflGIx0HjsY' \
--header 'Cookie: JSESSIONID=4F8DA88593F56C3AB9F128F9E447BE42' \
--data '{
    "caseTypeId": 1,
    "priorityId": 2,
    "caseTitle": "Login Issue",
    "caseDesc": "User is unable to log in to the system",
    "assignedTo": 5
  }'
