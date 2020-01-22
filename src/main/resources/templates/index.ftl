<!DOCTYPE html>
<html lang="utf-8">
<head>
    <title>index</title>
</head>
<body>
<div id="message"></div>
</body>
<script>
    var token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4TDVBcERHNXRFNTBJR0RObnR0ZzZJWGJZSlhHVTVyMlBTTEh3WG05Q3prIn0.eyJqdGkiOiI1MTg5MDFmZC02M2ZhLTQzN2UtYjQ5My01YjBiOGE1OGQ4YTciLCJleHAiOjE1Nzk2MDI4MjUsIm5iZiI6MCwiaWF0IjoxNTc5NTk5MjI1LCJpc3MiOiJodHRwczovL2tleWNsb2Frc3NvLjUxN2FwaS5jbi9hdXRoL3JlYWxtcy90ZXN0IiwiYXVkIjpbIm12Yy1hcGkiLCJhY2NvdW50Il0sInN1YiI6ImY6ZjNjZGE5NTMtYzhjNi00ZWM3LWFlODItMjU4NzU3OGI4ZTk3OnNoYW93ZW4iLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJjbGllbnQtanMtb2lkYyIsIm5vbmNlIjoiNzY5M2RlZTAtYjRkOC00OGQyLTg0MDUtYTZkOWE4Y2QxZjgxIiwiYXV0aF90aW1lIjoxNTc5NTk5MjI0LCJzZXNzaW9uX3N0YXRlIjoiOTgzZDViYTgtMGI4YS00ZjQwLTkyYjAtNTVjNDc0MjNkNzQ5IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vMTkyLjE2OC40LjE0NDoyMDAwMyJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImNsaWVudC1qcy1vaWRjIjp7InJvbGVzIjpbInVzZXIiXX0sIm12Yy1hcGkiOnsicm9sZXMiOlsidXNlciJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgcHJvZmlsZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IndlbiBzaGFvIiwicHJlZmVycmVkX3VzZXJuYW1lIjoic2hhb3dlbiIsImdpdmVuX25hbWUiOiJ3ZW4iLCJmYW1pbHlfbmFtZSI6InNoYW8ifQ.pMANRIS9H60OKfGMHpPR96i68NUctGa2K6ceLxamqHKinO8IMTuaSfPZj0uhCZK_7Essspf0unmVdbt7VxD8V2C-iHt4A-j0eXoMCLowt06v-XIh2EXcJ2J1a3XTR92ACB8B98eB4m-liPDwVv3OYylgKS3CUMyP7HjoeM5gUiMdHSy9fKVuopqkvtU4CsNpF56XQt5h7InjQ3WDNBGix6uNfIIOqK_TYqsGw7dtb6vO-BGlp6k08AGfe2R8ZZ-ERDD7tjrCT5NYVTyMB_asCvkFiqfa5qf1jp3bJL2uvKGzUdOkuO3AY7St-DHMRt4hbajLoBL085ByTpuGEcHq2g";
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
