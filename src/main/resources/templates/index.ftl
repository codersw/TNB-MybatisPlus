<!DOCTYPE html>
<html lang="utf-8">
<head>
    <title>index</title>
</head>
<body>
<div id="message"></div>
</body>
<script>
    var token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4TDVBcERHNXRFNTBJR0RObnR0ZzZJWGJZSlhHVTVyMlBTTEh3WG05Q3prIn0.eyJqdGkiOiI0MDgyMTVmYi1lMDI3LTRjYTgtOTAxYi1lNTBhZjc4MDViODkiLCJleHAiOjE1Nzk2OTM5NDgsIm5iZiI6MCwiaWF0IjoxNTc5NjU3OTYzLCJpc3MiOiJodHRwczovL2tleWNsb2Frc3NvLjUxN2FwaS5jbi9hdXRoL3JlYWxtcy90ZXN0IiwiYXVkIjpbIm12Yy1hcGkiLCJhY2NvdW50Il0sInN1YiI6ImY6ZjNjZGE5NTMtYzhjNi00ZWM3LWFlODItMjU4NzU3OGI4ZTk3OnNoYW93ZW4iLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJjbGllbnQtanMtb2lkYyIsIm5vbmNlIjoiMGI3ZTBhOGMtYTU3OC00MWZlLWE5YjUtOGZmMDZlMDUyOWQ2IiwiYXV0aF90aW1lIjoxNTc5NjU3OTQ4LCJzZXNzaW9uX3N0YXRlIjoiMmI3MjIxYzktNGNlYS00YWM3LWJjYTYtNmQ0ZjU4MjU4MzRiIiwiYWNyIjoiMCIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vMTkyLjE2OC40LjE0NDoyMDAwMyJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImNsaWVudC1qcy1vaWRjIjp7InJvbGVzIjpbInVzZXIiXX0sIm12Yy1hcGkiOnsicm9sZXMiOlsidXNlciJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgcHJvZmlsZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IndlbiBzaGFvIiwicHJlZmVycmVkX3VzZXJuYW1lIjoic2hhb3dlbiIsImdpdmVuX25hbWUiOiJ3ZW4iLCJmYW1pbHlfbmFtZSI6InNoYW8ifQ.Qf_w_SMRrFZMj4wSuR6XGfxtZgz_OpJevytu2c9mk3ewoSkNUx60EHF5n8QXSGOZe9fbzLoncIs7VF5DolLOMoUqt81wonWXKE-UshN_Xqwm76N0B9kqFItxgDYSHBavq9z_8l_vKKiHH5cb6whWzdZMwZBX82t62v8jabJrW1ZhTg0bASRRtzScDVVlhmIylNQZEub0mZQVKATYcfMhpE6YVFl_j9HWwe0e_f1aalIAE55cNaK6zg5ry77XxOB9kYvdDtLKcUqie7U1f9fLdzAhy2GqP-rBWOkAyYEHl_qYBVdRDQQC21YRCNd_mv3TJivtPUKmEmxAjd13U_rLFw";
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
