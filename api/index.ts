const BASE_URL = "http://18.102.24.178:9980/v1";

export type annualDataType = {
  labels: string[];
  data: string[];
};

export const annualApi = async (
  originID: string,
  destinationID: string,
  typeID: string,
  startYear?: string,
  endYear?: string
) => {
  const res = await fetch(
    `${BASE_URL}/data/annual/origin/${originID}/destination/${destinationID}/type/${typeID}${
      startYear !== undefined && endYear !== undefined
        ? `?startYear=${startYear}&endYear=${endYear}`
        : ""
    }`
  );
  const data = await res.json();

  const mappedData: annualDataType = { labels: [], data: [] };

  if (Array.isArray(data))
    data.map((el: any) => {
      mappedData.data.push(el.observation);
      mappedData.labels.push(el.year);
    });

  return mappedData;
};

export type monthlyDataType = {
  labels: string[];
  data: string[];
};

export const monthlyApi = async (
  originID: string,
  destinationID: string,
  typeID: string,
  startDate?: string,
  endDate?: string
) => {
  const res = await fetch(
    `${BASE_URL}/data/monthly/origin/${originID}/destination/${destinationID}/type/${typeID}${
      startDate !== undefined && endDate !== undefined
        ? `?startDate=${startDate}&endDate=${endDate}`
        : ""
    }`
  );
  const data = await res.json();

  const mappedData: monthlyDataType = { labels: [], data: [] };

  if (Array.isArray(data))
    data.map((el: any) => {
      mappedData.data.push(el.observation);
      
      if (data.length <= 12) {
        const monthDate = new Date(el.date);
        const monthString =
          monthDate
            .toLocaleString("it-IT", {
              month: "short",
            })
            .charAt(0)
            .toUpperCase() +
          monthDate
            .toLocaleString("it-IT", {
              month: "short",
            })
            .slice(1);
        mappedData.labels.push(monthString);
      } else {
        const monthDate = new Date(el.date);
        const monthString = monthDate.toLocaleString("it-IT", {
          month: "numeric",
          year: "2-digit",
        });
        mappedData.labels.push(monthString);
      }
    });

  return mappedData;
};
