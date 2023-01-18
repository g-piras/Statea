import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";
import { Bar } from "react-chartjs-2";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

export const labels = [
  "Gen",
  "Feb",
  "Mar",
  "Apr",
  "Mag",
  "Giu",
  "Lug",
  "Ago",
  "Set",
  "Ott",
  "Nov",
  "Dic",
];

export const data = [
  "120040",
  "165040",
  "200450",
  "224040",
  "80547",
  "56040",
  "344500",
  "487540",
  "134550",
  "165450",
  "234530",
  "422340",
]

export default function BarChart(props: {
  data: {
    labels: string[];
    datasets: [
      {
        data: string[],
        backgroundColor: string;
      }
    ];
  };
}) {
  const options = {
    maintainAspectRatio: false,
    plugins: {
      legend: {
        display: false,
      },
    },
  };

  return <Bar options={options} data={props.data} />;
}


