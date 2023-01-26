# TOURISTATS PROJECT - Statea &copy;

This is a project build with Next.js, a framework for building server-rendered React applications.

## Goal
- Building a website application related to the tourism industry. The product will be built using official [Istat](https://www.istat.it/) datasets regarding the trend of tourism in Sardinia. Specifically, the flow associated with the movements and choices of Italian and foreign tourists towards the Sardinia will be analyzed.

---

## Features
- Generation of statistics and charts with the possibility of consultation on the platform.
- Definition of an area of the platform dedicated to the visualization of forecasts on future tourist flows, based on the Machine Learning model trained and customizable by the end user through filters that can be set by platform (e.g. "What is the forecast for the flow of Italian tourists in Sardinia in 2023?")
- Server-side rendering for improved performance and SEO
- Mobile First
- Machine Learning to train the forecast models

---

## Used technologies
### **Front-End**
- React.js with Next.js as a framework 
- Tailwind CSS framework
- Third part React libraries: daisyui, chartJS

### **Back-End**
- Java with Spring Boot as a framework
- Docker
- Apache Kafka
- MariaDB

### **Fintech**
- Python
- Flask

---
## Installation
1) Clone this repository: https://github.com/KelosDev/Statea
    
    ```
    git clone https://github.com/KelosDev/Statea
    ```
    

2) Install the dependencies:
    
    ```
    npm i
    ```
3) Start the development server
   
   ```
   npm run dev
   ```

To use the api services you have to change the base url in the first line of the file [index.ts](./api/index.ts) from

```ts
const BASE_URL = "http://localhost:9980/v1";
```
to
```ts
const BASE_URL = "http://18.102.24.178:9980/v1";
```

---

## License

This project is licensed under the MIT License. See the [LICENSE](./LICENSE) for more information.

---
## Links

[README_FrontEnd](./README_Frontend.md)

[README_BackEnd](./Backend/readme.md)

[README_FinTech](./FinTech/README.md)