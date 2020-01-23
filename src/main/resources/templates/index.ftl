<!DOCTYPE html>
<html lang="utf-8">
<head>
    <title>index</title>
</head>
<body>
<div id="message"></div>
</body>
<script>
    var token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4TDVBcERHNXRFNTBJR0RObnR0ZzZJWGJZSlhHVTVyMlBTTEh3WG05Q3prIn0.eyJqdGkiOiIyZTBjZDVhMC1lZDcwLTQwN2MtOGU5Yi04YmM3YWI5MTcyOTkiLCJleHAiOjE1Nzk3OTg2OTcsIm5iZiI6MCwiaWF0IjoxNTc5NzYyNzEzLCJpc3MiOiJodHRwczovL2tleWNsb2Frc3NvLjUxN2FwaS5jbi9hdXRoL3JlYWxtcy90ZXN0IiwiYXVkIjpbIm12Yy1hcGkiLCJhY2NvdW50Il0sInN1YiI6ImZmMGU1ZDk2LWZhOTMtNGJiOS04M2RhLWY2NjI4MmZiZTcwNiIsInR5cCI6IkJlYXJlciIsImF6cCI6ImNsaWVudC1qcy1vaWRjIiwibm9uY2UiOiJjMjY5YmY5Ni01OGEzLTQ5NjUtYjdlZS1lMTcyNDgwMTM5MGYiLCJhdXRoX3RpbWUiOjE1Nzk3NjI2OTcsInNlc3Npb25fc3RhdGUiOiJhZDg4ZTJhYi0zZWJhLTQyOGItYWMxMy1hOGU5NzMwNDRkYzYiLCJhY3IiOiIwIiwiYWxsb3dlZC1vcmlnaW5zIjpbImh0dHA6Ly8xOTIuMTY4LjQuMTQ0OjIwMDAzIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiY2xpZW50LWpzLW9pZGMiOnsicm9sZXMiOlsidXNlciJdfSwibXZjLWFwaSI6eyJyb2xlcyI6WyJ1c2VyIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6Im9wZW5pZCBwcm9maWxlIGVtYWlsIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJuYW1lIjoidGlhbiB3YW5nIiwicHJlZmVycmVkX3VzZXJuYW1lIjoidGVzdCIsImdpdmVuX25hbWUiOiJ0aWFuIiwiZmFtaWx5X25hbWUiOiJ3YW5nIn0.IqSEKgqYZTCZUR-IkARcKUrUUJAutB1ZhTdsO8WT9skdZm3Eo2KLnoy_uSeKzVASAmnaBtHolaemcCBPIIoHXy10N0IVgDM7M1Az11SBpNW9NgpMaAApzBU5Nj9HgxRNQQBdzHnBEwXcRERPKojYwrEee3ODKQRpYvcdByF1x2Cnw1HkTt4wO4uCVuvGuureC05TwZ06OzdiCXoBoPh67I0x8iEmn7IINelpbjDINUyuPdZlv_X7loSxWRVKeMBKRZ_chtnqHsdeV2ZXYdxt-01uy79B-OARS2obIpP14cpvfyC1w7iGWGvLPXjLZxoKAvF9GJr-JXLDC3TjMAHHdg";
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
