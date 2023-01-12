/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx}",
    "./components/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      screens: {

        'mobile': '480px',
        // => @media (min-width: 480px) { ... }

        'tablet': '640px',
        // => @media (min-width: 640px) { ... }

        'laptop': '1024px',
        // => @media (min-width: 1024px) { ... }

        'desktop': '1280px',
        // => @media (min-width: 1280px) { ... }
      },
      keyframes: {
        rotateDx: {
          '0%': { transform: 'rotate(0.0deg)' },
          '100%': { transform: 'rotate(1080deg)' },
        },

      },
      animation: {
        'rotate': 'rotate 0.7s cubic-bezier(0.4, 0, 0.2, 1);'
      }
    }
  },
  plugins: [],
}
