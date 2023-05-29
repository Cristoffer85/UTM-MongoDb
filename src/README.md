# Personlig information - Cristoffer 

----------------------

## Projektrapport: MongoDB CRUD Utmaning

### Beskrivning av projektet
Vi fick i utmaning att göra ett program i Java som gör en anslutning emot MongoDB:s server, och om den inte fungerar där skall den ansluta lokalt istället. Programmet skall klara av att hantera CRUD emot båda typer av anslutning, och kravet var en databas med namnet 'Personer' och två kollektioner med 'Kunder' och 'Anställda'.

### Planering
Började tidigt med att försöka läsa på/ta in guider och föreläsningar ifrån bla W3schools och MongoDB:s egna sida med undervisningsmaterial. Gick igenom Marcus föreläsningar igen, noggrannt i lugn och ro och detaljläste (så man nog måste göra, dubbelläsa och repetera (Repetition == Kunskapens moder) och få in kunskapen igen det är så den fastnar till slut) Efter att ha läst på och gått igenom grundprogrammet som Marcus själv skrivit på lektion, och fått en insikt planerade jag klasserna och annat lokalt i IntelliJ endast, mha lokala kommentarer.

### Utveckling
Började med att bygga anslutnings-klassen, tillsammans med Keyreader-klassen för att vara säker på att den fungerade (de som kändes mest vitala - för att få fram en fungerande anslutning samt att lösenordet till mongoDB inte svävade iväg någonstans på internet osäkert..) Tog sedan tag i DBCRUD-klassen för att hantera CRUD:en därifrån och till de olika baserna, tog till sist lull-lullet med Meny:n och Main för att få till det övriga samt att instansieringar emellan klasserna blev rätt. Skrev sist en enklare readme.md med programinformation som kravspec:en hade krävt att vi skulle.

### Datatyper
Try-catch mestadels i anslutnings- och keyreaderklassen då de känns mest vitala och bäst använda där (testar anslutning men fångar undantag annars och visar felmeddelande, i princip) Sedan massa villkors if-else i DBCRUD och enhanced switch i meny-klassen då jag gillar de bäst. 

### Vem gjorde vad
Cristoffer gjorde allt själv i detta program då det var en enskild utmaning.

### Vad kunde ha gjorts bättre
Kunde ha refaktorerat och gjort koden ännu finare, samt ev. lagt in ett interface så den hämtade lite fina saker med getters och setters med, men valde denna metod. Kunde även ha testkört programmet lite mer så att det verkligen fungerade med den lokala anslutningen helt med, men var pga tidsbrist och annat som fick göra det jag kunde denna gång, bara.

### Slutsatser
Väldigt spännande! Jag tror MongoDB är just den serverlösningen jag fastnade för mest hittills, och är den jag kommer/vill använda i mina framtida egna databas-Crud-projekt för diverse saker, både privat och på arbete om möjlighet så ges.

### Backlog
Skrev ingen/gjorde inget spec. på Github mer än skapa repo denna gång då inte hade det i tankarna/krav om jag ska vara ärlig.

### Beskriv lite olika lösningar du gjort
Testade många olika saker för att få CRUD:en att fungera in till databasen, kommer inte ihåg exakt vad jag gjorde nu men det var en del som strulade. Tog sedan hjälp av Google för att få till bla "Update"-delen kommer jag ihåg då den småstrulade lite, fick sedan ihop det. Try-catch:en för den lokala biten i anslutning krånglade lite med, trodde jag hade fått ihop den bra och så att den fungerade men det gjorde den inte. Nu gör den dock det :)

### Beskriv något som var besvärligt att få till
DBCRUD:en, göra den fin och bra. Hade nog velat refaktorerat den så att den såg bättre/finare ut men vad gör man då man har mindre med tid etc.

### Beskriv om du fått byta lösning och varför i sådana fall
Jag kan inte komma på någon nu.

### Vad gick bra
Att få ihop databasen+anslutningen där tillsammans med Keyreader! Fantastiskt att se att det fungerar, och man kan ansluta utan att behöva ange sitt lösenord skickat över internet med! Säkert (helt förhoppningsvis..) och bra.

### Vad gick dåligt
Tiden, tidsbristen igen. Man fick göra det man kunde på den korta tiden för att få ihop ett fungerande program bara. Hann inte testa programmet tillräckligt innan släpp, annars hade det nog blivit bra.

### Vad har du lärt dig
Hur man ansluter en MongoDB emot server och om inte fungerar ansluter lokalt istället! + Att den använder Keyreader klass med lösenordet hemligt lokalt lagrat. Coolt att se hur information man knattrar in i ett egengjort program i IntelliJ tillsammans med en snabb/halvihopkastad meny faktiskt fungerar och slänger upp information på nätet eller lokalt och fungerar!

### Vilka möjligheter ser du med de kunskaper du fått under kursen
Många, kan skapa databaser (CRUD) på internet och lokalt samtidigt som integrerar de med i princip vilka API:n jag vill. Man kan bygga i princip vad man vill, bara beroende på vad kyparna (API:erna) vill visa och generera då.

--------------
# Programrelaterad information

## Moduler
+ Maven org.mongodb:mongo-java-driver:3.2.13
+ Maven org.mongodb:mongodb-jdbc:2.0.2

## Main
+ runMenu()

## Meny
+ new Anslutning()
+ runMenu()

## Anslutning
+ new KeyReader()
+ new DBCRUD()

## KeyReader
+ getPassCode() - Klass+Metod för att hantera så man inte lägger upp sitt lösenord online, sparas i en .txt lokalt och hämtas där

## DBCRUD
+ addCustomer()
+ updateCustomer()
+ deleteCustomer()
+ printAllCustomers()
+ //---------------------
+ addEmployee()
+ updateEmployee()
+ deleteEmployee()
+ printAllCustomers()




