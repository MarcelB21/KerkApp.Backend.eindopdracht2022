#Integrale eindopdracht Bootcamp FSD (60 EC)
De bootcamp Full Stack Developer behandelt zowel de leerlijn Backend als de leerlijn Frontend.
Om de bootcamp af te ronden dien je de volgende leeruitkomsten aan te tonen:
Backend:

#1.Java Programming
[v] De student programmeert in Java,
[v] waarbij hij OOP-structuren toepast.
[] Hierbij past de student automatisch testen toe
[v] beheert hij externe code met behulp van Maven, waardoor men in een team aan Java-projecten kan werken.

#2.Backend Documentatie
[] De student stelt, op basis van de Software Development Life Cycle, technische documentatie
op voor de backend van een applicatie,
[]gebruik makend van UML-diagrammen.

#3.Database Development
[v] De student ontwerpt een relationele database,
[] waarin data met onderlinge relaties veilig opgeslagen en uitgelezen kan worden,
[v] aan de hand van een technisch ontwerp document.
[v] Tevens beheert de student de:
[v] data
[v] rechten van databasegebruikers
[v] voert hij CRUD- opdrachten uit op de database.

#4.Spring Boot
[] De student zet een backend applicatie op met behulp van het
[v] Spring-boot framework
[v] maakt gebruik van verschillende architecturale lagen binnen Spring.
[] De student test zijn applicatie met unit-testen
[] en het mocken van klassen
[v] en tevens communiceert de applicatie met een database.

#5.Design Patterns & Clean Code
[v] De student schrijft zijn code volgens de afgesproken conventies van Clean Code
[v] en ontwikkelt highly cohesive
[v] en loose coupled code,
[v] door de toepassing van:
[v] Design Patterns
[v] en SOLID.

#Deelopdrachten 2 & 3: Programmeerfase
[v] Je hebt zojuist de ontwerpfase afgerond, het is nu tijd om de applicatie te bouwen!
In de programmeerfase ga je zowel de
[v] backend als de
[v] frontend uitwerken.

Hieronder vind je de bijbehorende deelopdrachten. De wijze waarop je de applicatie bouwt,
[v] sluit aan bij de eisen die je hebt opgesteld in de ontwerpfase.
[v] Je applicatie dient een multi tier applicatie te zijn.

In de programmeerfase houd je rekening met de volgende algemene punten:
[v] Multi-tier application:
[v] frontend
[v] backend
[v] database
[v] Je beheert je code met gebruik van Git om met versiebeheer de voortgang van het project vast te leggen.
[] Je applicatie bevat een vorm van media-upload. Een eindgebruiker moet bijvoorbeeld een
afbeelding, een mp3-bestand of een pdf kunnen uploaden;
[] Je applicatie bevat unit-testen.

#Deelopdracht 2. Programmeerfase - backend
[v] De backend van de applicatie ontwikkel je in Java,
[v] met behulp van het Spring Boot framework.
[v] Afhankelijk van de complexiteit van het op te lossen probleem, gebruik je OOP-structuren zoals
[v] overerving,
[v] interfaces
[v] abstracte klassen.
[v] Met behulp van Spring Security pas je
[v] autorisatie
[v] authenticatie toe.
[v] Je gebruikt HTTP-methods om de vertaalslag te maken naar acties met de data.

[v] Je gebruikt verschillende componenten van Spring-boot, zoals (maar niet gelimiteerd tot)
[v] de annotaties en configuratie van de applicatie.
[v]Je let hierbij op de principes van:
[v] Clean Code
[v] Design Patterns
[v] SOLID
[] Je test geschreven klassen individueel met unittests die gebruik maken van de drie A’s,
[] waarbij de test coverage minimaal 50% is exclusief getters en setters.
[] Ook voer je integratie-testen uit door de application context van de applicatie te testen gebruikmakend van:
[] Spring Boot test
[] WebMvc
[v] Je past de principes Maven build lifecycle toe bij het beheren van externe code en libraries.
[v] Alle data sla je op in een SQL database waarbij je zorg draagt voor de
[v] autorisatie
[v] authenticatie in de database.

Houd verder bij het programmeren rekening met onderstaande punten:
[v] Je ontwikkelt volgens OOP-principes en met behulp van Java & Spring-boot;
[v] Je maakt gebruik van Maven;
[v] Je applicatie is beveiligd en bevat meerdere user rollen;
[v] Je maakt gebruik van een relationele database. 

#Deelopdracht 4. Opleveringsfase
[] Zodra je begint met programmeren, ga je ook beginnen aan het verantwoordingsdocument.
[] Hierin leg je vast welke
[] technische ontwerpbeslissingen je maakt
[] en waarom je deze keuzes gemaakt hebt.
[] Dit werkt het beste als je dit al tijdens het ontwikkelen van jouw product begint te maken.
[] Waarom heb je deze specifieke npm package
[] of Java-library gebruikt en niet een andere?
[] Waarom ben je van conventies
[] of architecturale richtlijnen afgeweken?
[] Welke doorontwikkelingen zijn er mogelijk
[] of misschien zelfs wenselijk,
[] en waarom heb je deze zelf niet door kunnen voeren?
[] Heb je bijvoorbeeld iets achterwege gelaten in verband met een tekort aan tijd?
[] Leg dan uit wat je liever had willen doen als je meer tijd had gehad.
[] Reflecteer hierbij ook op je eigen leerproces:
[] wat ging goed
[] en wat kan de volgende keer beter?
[] Let op: technieken die als randvoorwaarden gesteld zijn in de eindopdracht tellen niet mee.
[] Daarnaast schrijf je een installatiehandleiding die uitlegt hoe de
[] applicatie geïnstalleerd kan worden
[] en hoe deze gebruikt kan worden.
[] Je neemt hierin een lijst op van:
[] benodigdheden om de applicatie te kunnen runnen,
[] een lijst met (test)gebruikers
[] en user-rollen,
[] een lijst van rest endpoints (inclusief JSON-voorbeelden)
[] en op welke manier deze beveiligd zijn.
[] Ook voeg je een stappenplan met installatie instructies toe.

#Randvoorwaarden
Hieronder vind je een aantal randvoorwaarden waaraan je eindopdracht moet voldoen. Deze randvoorwaarden hebben een
verplicht karakter.
[v] Alleen React met JavaScript wordt geaccepteerd als programmeertaal in de frontend (geen TypeScript).
[v] Alleen Java wordt geaccepteerd als programmeertaal in de backend. Je maakt gebruik van het Spring-boot framework.
[] De projecten zijn geüpload naar een GitHub repository: deze repository staat op public.
[] Het ingeleverde bestand bevat geen
[] ‘node_modules’
[] ‘.idea’-map,
[] ‘target’-map
[] ‘out’- map.
[v] Het frontend project bevat de JavaScript linter ESLint. Bij gebruik van create-react-app is dit
standaard meegeleverd.
[] De wireframes zijn getekend op papier.
[] Het prototype is ontworpen met Figma. Indien je liever Adobe XD wil gebruiken, mag dit ook.
Deze software is helaas niet langer gratis.
[] Er is géén gebruik gemaakt van out-of-the-box styling systemen zoals
[] Bootstrap
[] Material-UI
[] Tailwind.
[] Het volledige project en bijbehorende documenten wordt aangeleverd d.m.v. een ZIP- bestand van:
[] maximaal 50 MB. (Met de extensie .zip. Projecten die als .rar worden aangeleverd, worden niet geaccepteerd.)
Het ZIP-bestand bevat de volgende elementen:
[] Readme (in markdown)
[] Beschrijft waar alle documenten en applicaties te vinden zijn
[] Bevat een link naar de GIT repository waarnaar het project (of projecten) geüpload is.
[] Je hebt Maven en NPM gebruikt als dependency manager.
[] De applicatie start op zonder te crashen.
[] Installatiehandleiding (in .pdf of markdown)
[] Functioneel ontwerp (in .pdf of markdown)
[] Technisch ontwerp (in .pdf of markdown)
[] Broncode van beide projecten (Let op: dus niet alleen de link naar het Github-project)
[] Verantwoordingsdocument (in .pdf of markdown)
Structuur
[] Naast de bijgevoegde losse schermontwerpen introduceer je deze schermontwerpen ook al te bij het
functioneel ontwerp.
[] Ook wireframes behoren voorzien te worden van paginatitels en beschrijving zodat het duidelijk is over
welke pagina het gaat.
[] Er is geen harde richtlijn met betrekking tot het aantal woorden,
[] maar zorg ervoor dat je beknopt en bondig schrijft.
[] In de documenten (installatiehandleiding en het technisch- en functioneel ontwerp) zitten geen verwijzingen
naar afbeeldingen, diagrammen of modellen buiten het document zelf. Ook zijn de diagrammen en afbeeldingen
goed leesbaar en tekstueel uitgelegd of beschreven. Een goed uitgangspunt hier is wanneer het document
geprint wordt, deze nog steeds volledig beoordeeld kan worden.
[] De installatiehandleiding en het technisch- en functioneel ontwerp zijn beide voorzien van een
[] inhoudsopgave
[] en inleiding.
[] Ze zijn verzorgd
[] en hebben een titelblad
[] met datum
[] en naam van de auteur.
[] De documenten bevinden zich ook op een logische plaats in het inleverbestand.

#Beoordelingscriteria:
De eindopdracht wordt beoordeeld op basis van de volgende beoordelingscriteria.
Per criterium kent de beoordelaar een aantal punten toe.
[] Hierbij wordt zowel gekeken naar de feitelijke realisatie van de leeruitkomst
[] als naar het door de student getoonde inzicht in de bijbehorende theorie.
2. Backend totaal 35%
   In deze deelopdracht worden aspecten van de gehele leerlijn Backend getoetst.
   Criterium 2.1 10%
   De student maakt Java applicaties waarbij hij op de juiste momenten, afhankelijk van de complexiteit
   van het op te lossen probleem,
   [v] OOP- structuren gebruikt zoals
   [v] overerving,
   [v] interfaces en
   [v] abstracte klassen
   [v] en de student schrijft Java- code op basis van
   [v] Clean Code,
   [v] Design Patterns
   [v] SOLID.

#Criterium 2.2 - 5%
[v] De student gebruikt HTTP-methods om de vertaalslag te maken naar acties met de data.

#Criterium 2.3 - 5%
[v] De student past autorisatie en authenticatie toe
[v] met behulp van Spring Security
[v] en de student gebruikt verschillende componenten van Spring- boot
[v] zoals, maar niet gelimiteerd tot,
[v] de annotaties
[v] en configuratie van de applicatie.

#Criterium 2.4 - 5%
[] De student voert integratie-tests uit
[] door de application context van zijn applicatie te testen.
[] Hiervoor gebruikt hij Spring-Boot test en WebMvc.
[] Tevens voert de student unittests uit die gebruikmaken van de drie A’s,
[] waarbij de test coverage minimaal 50% is exclusief getters en setters).

#Criterium 2.5 - 5%
[v] De student past de principes Maven build lifecycle toe
[v] bij het beheren van externe code
[v] en zijn libraries
[v] en de student beheert zijn code met gebruik van Git om met versiebeheer de voortgang van het project
vast te leggen.
[v] De student heeft kleine commits,
[v] maakt pull requests
[v] en mergt regelmatig.

#Criterium 2.6 - 5%
[v] De student leest en bewerkt data met behulp van
[v] SQL,
[v] JPA
[v] en Hibernate
[v] en draagt zorg voor de
[v] autorisatie
[v] en authenticatie in de database.

#3. Opleveringsfase totaal - 10%
   [] In deze deelopdracht worden aspecten van de cursus Backend Documentatie getoetst.
   Criterium 4.1 5%
   [] De student schrijft een duidelijk geschreven installatiehandleiding
   [] waarmee de applicatie door derden in een andere omgeving kan worden geïnstalleerd,
   [] voorzien van stappenplan,
   [] lijst van benodigdheden,
   [] testgebruikers,
   [] userrollen,
   [] rest-endpoints
   [] en voorbeeld JSON.
   Criterium 4.2 5%
   [] De student levert een verantwoordingsdocument op
   [] waarbij hij reflecteert op zijn code en beargumenteert
   [] minimaal 10 gemaakte technische keuzes.
   [] De student beschrijft realistische limitaties van zijn applicatie
   [] en welke doorontwikkelingen mogelijk en/of wenselijk zijn.
4. 
   Let OP!!
   bij het veranrwoording document dat bij het uploaden van afbeeldingen er een verschil zit tussen windows of mac ge bruikers
   in het op slaan van het mapje in de //
   dit is terug te zien in de fullstack workshop over hoe te koppelen van frond en back end 15 jun ongeveer van af
   tijd 0:55:00
