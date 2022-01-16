## Instruction
<h5>1. start MySQL server (use XAMPP/WAMPP/etc)</h5>
<h5>2. Configure your db connect in application properties</h5>
<h5>3. Run main class</h5>

## API Path
**GET** : http://localhost:8080/youtube-trending <br>
**POST** : http://localhost:8080/youtube-trending <br><br>

Example of Request Body For POST <br><br>
{ <br>
"channelId": "TE68busdbs", <br>
"title": "Test New Title", <br>
"channelName": "New Channel Name", <br>
"publishedAt": "2022-01-07" <br>
}

**DELETE** : http://localhost:8080/youtube-trending/{id} <br>
**PUT** : http://localhost:8080/youtube-trending/{id}?channelId=..&title=..&channelName=..&publishedAt=..
<br><br>
Params for PUT is optional, example :
http://localhost:8080/youtube-trending/123?channelId=89HUINdfhiusdb0&title=Hey%20Yeah%20You&channelName=ARGO%20PURO&publishedAt=2022-01-07