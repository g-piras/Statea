const BASE_URL = "http://18.102.24.178:9980/v1"

export const getData = async (query: string) => {

    const res = await fetch(`${BASE_URL}/${query}`);
    const data = (await res.json())

    return data;
}

export type monthlyApiType = {
    labels: string[],
    data: string[]
}

export const monthlyApi = async (destinationID: string, typeID: string, startDate?: string, endDate?: string) => {

    const res = await fetch(`${BASE_URL}/data/monthly/origin/WORLD/destination/${destinationID}/type/${typeID}${startDate !== undefined && endDate !== undefined ? `?startDate=${startDate}&endDate=${endDate}` : ""}`);
    const data = (await res.json())

    const mappedData: monthlyApiType = { labels: [], data: [] }

    if (Array.isArray(data))
        data.map((el: any) => {
            mappedData.data.push(el.observation)

            const monthDate = new Date(el.date)
            const monthString = monthDate.toLocaleString("it-IT", {
                month: "short"
            }).charAt(0).toUpperCase() + monthDate.toLocaleString("it-IT", {
                month: "short"
            }).slice(1);
            mappedData.labels.push(monthString)
        });

    return mappedData;
}
