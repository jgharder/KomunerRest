const out = function (str) {
    console.log(str)
}

function getAllKommuner() {
    out("getAllKommuner() kaldt")
    const kommuneApi = "https://api.dataforsyningen.dk/kommuner"
    return fetch(kommuneApi).then(response => response.json()
    )
}

out("start hent kommuner")

function callGetAllKommuner() {
    out("callGetAllKommuner() kaldt")
    const prom = getAllKommuner()
    out(prom)
    out(prom.then(showKommuneData))
}

function showKommuneData(data) {
    out("vi skriver data ud")
    data.forEach(kom => {
        kommuneJson.kommuneKode = kom.kode;
        kommuneJson.kommune = kom.navn;
        kommuneJson.regionKode = kom.region.kode;
        kommuneJson.regionHref = kom.region.href;
        kommuneJson.regionsNavn = kom.region.navn;

        //out(body)

        body = JSON.stringify(kommuneJson);

        postKommuneRequest.body = body;

        fetch(postKommuneUrl, postKommuneRequest).catch(error => out(error));
    })
}

let postKommuneUrl = "http://localhost:8080/kommune";

let body;
let postKommuneRequest = {
    method: "Post",
    headers: {"content-type": "application/json"},
    body: body
}

let kommuneJson = {
    "kommune": "",
    "kommuneKode": "",
    "regionKode": "",
    "region": "",
    "regionsNavn": ""
}


const pbGetkommuner = document.querySelector(".pbGet")

pbGetkommuner.addEventListener("click", callGetAllKommuner)
