<!DOCTYPE html>
<html lang="utf-8">
<head>
    <title>index</title>
</head>
<body>
<div id="message"></div>
</body>
<script>
    var token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4TDVBcERHNXRFNTBJR0RObnR0ZzZJWGJZSlhHVTVyMlBTTEh3WG05Q3prIn0.eyJqdGkiOiJmMmFiMmQ1OC1mNjY2LTQ5YWEtOTk2NC0xNjdkYzUxNTU5N2UiLCJleHAiOjE1Nzk3OTgxNTQsIm5iZiI6MCwiaWF0IjoxNTc5NzYyNDg3LCJpc3MiOiJodHRwczovL2tleWNsb2Frc3NvLjUxN2FwaS5jbi9hdXRoL3JlYWxtcy90ZXN0IiwiYXVkIjpbIm12Yy1hcGkiLCJhY2NvdW50Il0sInN1YiI6ImY6ZjNjZGE5NTMtYzhjNi00ZWM3LWFlODItMjU4NzU3OGI4ZTk3OnNoYW93ZW4iLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJjbGllbnQtanMtb2lkYyIsIm5vbmNlIjoiY2U2NjI4ZjktOWI0Ni00Y2FiLTk2MTYtMjhhNDM2ZmNkNmRkIiwiYXV0aF90aW1lIjoxNTc5NzYyMTU0LCJzZXNzaW9uX3N0YXRlIjoiMGM3ZDllNDMtZTVhZC00YzJlLTkzNDItMWJmY2Y1MjdmOTM5IiwiYWNyIjoiMCIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vMTkyLjE2OC40LjE0NDoyMDAwMyJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImNsaWVudC1qcy1vaWRjIjp7InJvbGVzIjpbInVzZXIiXX0sIm12Yy1hcGkiOnsicm9sZXMiOlsidXNlciJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgcHJvZmlsZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IndlbiBzaGFvIiwicHJlZmVycmVkX3VzZXJuYW1lIjoic2hhb3dlbiIsImdpdmVuX25hbWUiOiJ3ZW4iLCJmYW1pbHlfbmFtZSI6InNoYW8ifQ.xN3buMFtlvCGs9t7jUNsfbqvmnzjydLnOgdvj38XpoDqWguhvlcGsKaan0KigNTbqSbsoN3sLaCN7SorN8Z8KKgFPRnpYYpinrwdA-hccoUYCgfPHeI3MF1VKvL68E6YfSbPh1FL3WpwJI0mV-I2f4ZPGCANfeJXSZ9OusyS7SzTszVOKA2yPFwUwtIRrDw41iwKjo8_ExE7BL_Gw19g4rnz5sCXJ_IkvM7MCKO_gUEJNyuqKTF2xJQBK50cXn99I3wXwq0V2Ua-_iVXweatg89ZYxDIYagH7rQefnDRuYTqT_uCp9zy-c-fo8r0zg8LVy-GDQsCcVaqT4lHqbPIwg";
    var req = new XMLHttpRequest();
    var output = document.getElementById('message');
    req.open('GET', '/user', true);
    req.setRequestHeader('Authorization', 'Bearer ' + token);
    req.onreadystatechange = function() {
        if (req.readyState === 4) {
            if (req.status === 200) {
                output.innerHTML = 'Message: ' + req.responseText;
            }
        }
    };
    req.send();
</script>
</html>
