# Touristats - Front-End Readme

## **How to start**

This project was created using Next.js. After cloning the repository and installing all dependencies, using the commands: 

```
1) git clone https://github.com/KelosDev/Statea
2) npm i
```

Type in command line:
```
npm run dev
```
to enter development mode.

At this point the application will be executed at localhost:3000.

---

## Site description and usage

**`Home`**:
We have a first overall view of what the site is. In detail, a graph representing statistics on tourism flow for the year 2021. Immediatly below there is another graph that instead shows the forecasts for 2023.

By clicking on the:

**`Statistiche`** button, you arrive at the statistics page where ther is a first graph that shows all statistics starting from 2008 to 2021. You can already see above the graph the filters that are active at the time of page loading.

To customize the results, the user can press the 'Filtra' button above the graph. Pressing the button will open a menu where you can choose to see annual data or even monthly data using respectively the 'Range di Anni' and 'Periodo' options.

You can also choose the various nationalities of tourists arriving in Sardinia and there is the possibility to see the data also for individual provinces.

**Note**: Selecting 'Periodo' the nationalities that can be chosen are only 'Tutte le nazionalità' that icludes Italy, 'Tutte le nazionalità - Italy is not included' e 'Italia'. This is due to the availability of data from ISTAT. 

Once the desired filters are selected, just click on the round button with a checkmark in the middle to confirm the changes and see the new updated grapg appear. As for

**`Previsioni`** page, the steps to take are completely analogous to those already described for the 'Statistiche' page.

**`About`** page instead, you can find a brief description of the company and the components that make it up and worked on the project.

---

## **Configuration and technical characteristics**

We used hooks to manage the state of our components. We specifically used `useState` and `useEffect`

In the [Navbar](./components/Navbar.tsx) file you can find:

```ts
const [nav, setNav] = useState(false); // to save the state of our navbar component (open or close)
```
In the [Sidebar](./components/Sidebar.tsx) file you can find:

```ts
const [selected, setSelected] = useState("first"); // to save the state of which of 'Range di Anni' and 'Periodo' is selected

const [province, setProvince] = useState("ITG2"); // to save the province ID

const [startYear, setStartYear] = useState("2008"); // to save the start year date

const [endYear, setEndYear] = useState("2021"); // to save the end year date

const [yearOptions, setYearOptions] = useState(yearOptionsControl(province)) // to save the year based on the selected province
```
In the [Index](./pages/index.tsx) file you can find:

```ts
const [months, setMonths] = useState<string[]>([]); // to save the month date

const [touristsNumber, setTouristsNumber] = useState<string[]>([]); // to save the  number of tourists for statistics

const [touristsNumberForecast, setTouristsNumberForecast] = useState<string[]>([]); // to save the  number of tourists for forecasts

const [monthsForecast, setMonthsForecast] = useState<string[]>([]); // to save the month date for forecasts
```

In the [Previsioni](./pages/previsioni.tsx) file you can find:

```ts
  const [side, setSide] = useState<boolean>(false); // to save the state of sidebar (open or close)
  const [years, setYears] = useState<string[]>([]); 

  // This code declares 8 state variables using useState hook, initial values are set for each of them.
  const [nationality, setNationality] = useState<string>("WORLD");
  const [province, setProvince] = useState<string>("ITG2");
  const [year, setYear] = useState<undefined | string>(undefined);
  const [firstSelectMonth, setFirstSelectMonth] = useState<undefined | string>(undefined);
  const [firstSelectYear, setFirstSelectYear] = useState<undefined | string>(undefined);
  const [secondSelectMonth, setSecondSelectMonth] = useState<undefined | string>(undefined);
  const [secondSelectYear, setSecondSelectYear] = useState<undefined | string>(undefined);
  const [yearStartRange, setYearStartRange] = useState<undefined | string>("2023");
  const [yearEndRange, setYearEndRange] = useState<undefined | string>("2030");
```
In the [Statistiche](./pages/statistiche.tsx) file you can find the same hooks as in 'Previsioni' page.

---

## Functions

[Index.ts](api/index.ts)

```ts
export const annualApi = () => {}
/* This function, annualApi, is an asynchronous function that makes a fetch request to a specified API endpoint to retrieve annual data, takes five parameters: originID, destinationID, typeID, startYear and endYear and returns mapped data. */

export const annualApiForecast = () => {}
/* This code exports a function called "annualApiForecast" that takes in five parameters: "originID", "destinationID", "typeID", "startYear", and "endYear". The function uses the Fetch API to make a GET request to a specified URL with the provided parameters included in the URL. The response is then parsed as JSON and mapped to a new object called "mappedData" with properties "labels" and "data" before being returned. The optional parameters "startYear" and "endYear" are included in the URL as query parameters if they are provided. */

export const monthlyApi = () => {}
/* This code exports a function that makes GET request with provided parameters and returns mapped object with "labels" and "data" properties, "startDate" and "endDate" are optional in the url, it parses response as JSON and maps it to "mappedData" object. "labels" are populated with month and year obtained by using "toLocaleString" method on date of each element in response.*/

export const monthlyApiForecast = () => {}
/* This code exports a function that makes a GET request with provided parameters and returns a mapped object with "labels" and "data" properties, "startDate" and "endDate" are optional parameters in the url and it's calling forecasted data. */
```
[Navbar.tsx](./components/Navbar.tsx)

```ts
const handleNav = () => {}
/* This code defines a function that toggles a boolean value by using the setNav function and passing the opposite of current state of nav as argument. */
```

[previsioni.tsx](./pages/previsioni.tsx)

```ts
const handleSidebar = () => {}
/* This code defines a function that toggles a boolean value by using the setSide function and passing the opposite of current state of side as argument. */

const handleSaveFilters = () => {} 
/* This function, handleSaveFilters, handles the saving of filters for a tourism data application. It takes in several parameters such as nationality, province, year, firstSelectMonth, firstSelectYear, secondSelectMonth, secondSelectYear, yearStartRange, and yearEndRange. It sets the corresponding state variables and then checks which filter options have been selected and makes API calls accordingly. It also calls the handleSidebar function at the end. */
```

---

## Components

- [BarChart.tsx](./components/BarChart.tsx)  -> To customize the chart and set data
- [Navbar.tsx](./components//Navbar.tsx) -> To handle the navbar
- [Footer.tsx](./components/Footer.tsx) -> Footer
- [Sidebar.tsx](./components/Sidebar.tsx) -> To handle the filter sidebar

---

## **Browser compatibility**
Browser Compatibility:
- Chrome V109.0.5414.119 (64bit): tested and working.
- Firefox V109.0 (64 bit): tested and working.
- Edge V109.0.1518.61 (64 bit): tested and working.
- Opera V94.0.4606.65 (64bit): tested and working.
- Brave V1.47.175 (64bit): tested and working.
- Safari V16.2 : tested and working

---

## **Contacts**
>- federico.stroppiana@edu.itspiemonte.it
>- giampietro.piras@edu.itspiemonte.it
>- joele.melchiorre@edu.itspiemonte.it
>- sebastiano.demichelis@edu.itspiemonte.it

---

## **Authors**     

- Federico Stroppiana 
- Giampietro Piras
- Joele Melchiorre 
- Sebastiano Demichelis 

---

## **Changelog and version history**  
For this project we used a mix of git version control.

 The [git](git-history.txt) history is embedded in the project folder.

 Link repository [GitHub](https://github.com/KelosDev/Statea)


