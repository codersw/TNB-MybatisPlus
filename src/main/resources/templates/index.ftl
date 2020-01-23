<!DOCTYPE html>
<html lang="utf-8">
<head>
    <title>index</title>
</head>
<body>
<div id="message"></div>
</body>
<script>
    var token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4TDVBcERHNXRFNTBJR0RObnR0ZzZJWGJZSlhHVTVyMlBTTEh3WG05Q3prIn0.eyJqdGkiOiJkZWYyMWJjMS1lN2VkLTRiMzQtYTdkZi0yOTRkMTZhNmZkZGEiLCJleHAiOjE1Nzk3NzkwMzYsIm5iZiI6MCwiaWF0IjoxNTc5NzQzMDUxLCJpc3MiOiJodHRwczovL2tleWNsb2Frc3NvLjUxN2FwaS5jbi9hdXRoL3JlYWxtcy90ZXN0IiwiYXVkIjpbIm12Yy1hcGkiLCJhY2NvdW50Il0sInN1YiI6ImY6ZjNjZGE5NTMtYzhjNi00ZWM3LWFlODItMjU4NzU3OGI4ZTk3OnNoYW93ZW4iLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJjbGllbnQtanMtb2lkYyIsIm5vbmNlIjoiNzIyMWY3YTUtMGYyOS00NmQ5LTg4NjQtMjg3YzFmMDc1YWE4IiwiYXV0aF90aW1lIjoxNTc5NzQzMDM2LCJzZXNzaW9uX3N0YXRlIjoiMTdhNjM3OWQtOGRjYi00MmI5LWJlMTMtNGRhN2M0ZGRmZDc5IiwiYWNyIjoiMCIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vMTkyLjE2OC40LjE0NDoyMDAwMyJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImNsaWVudC1qcy1vaWRjIjp7InJvbGVzIjpbInVzZXIiXX0sIm12Yy1hcGkiOnsicm9sZXMiOlsidXNlciJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgcHJvZmlsZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IndlbiBzaGFvIiwicHJlZmVycmVkX3VzZXJuYW1lIjoic2hhb3dlbiIsImdpdmVuX25hbWUiOiJ3ZW4iLCJmYW1pbHlfbmFtZSI6InNoYW8ifQ.Q2eMq4FpzZaq14-g_zUQxFyhII5D-BYAS2sraYN1Yw_ZIST_VsbIAIcfwbn2HsDB1-B9Ocgm93BqU7PmIoCuQHGxJIJDNacEkgQg4d8X91PMFzC8oVVtZhBnsVUzoXxzPaA5Ym3QYmhB0ASc0arAQlKTH5kqjC7W_99pPVn3qyMQSwoFysGBvyKy4e5VYVgF5t2BvzYFZVS1y6aJ_bgM7-z9hDh0BxmvGFhlrmA5Xf6dsremkSD4R90SEap2JnenEj_av1dS0OTPUNxpv0xmbe1NdKPbyoSKjOBdrn55KBbW38tYJYI40zmSyl4xNdeEwduGHcQJiYdZq8vG-nBRFw";
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
