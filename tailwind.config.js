/**
 * @type {import('tailwindcss').Config}
 */
module.exports = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx}",
    "./components/**/*.{js,ts,jsx,tsx}",
  ],
  plugins: [require("daisyui")],
  daisyui: {
    styled: true,
    themes: false,
    base: false,
    utils: false,
    logs: false,
    rtl: false,
    prefix: "",
    darkTheme: "light",
  },
  theme: {
    extend: {
      screens: {
        mobile: "480px",
        // => @media (min-width: 480px) { ... }

        tablet: "640px",
        // => @media (min-width: 640px) { ... }

        laptop: "1024px",
        // => @media (min-width: 1024px) { ... }

        desktop: "1280px",
        // => @media (min-width: 1280px) { ... }
      },
      keyframes: {
        rotate: {
          "0%": { transform: "rotate(0.0deg)" },
          "100%": { transform: "rotate(1080deg)" },
        },
      },
      animation: {
        "rotate-360": "rotate 0.5s ease-in-out;",
        "rotate-infinite": "rotate 0.5s linear infinite",
      },
    },
  },
};
