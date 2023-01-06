import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  value: false,
};

export const navbarSlice = createSlice({
  name: "navbar",
  initialState,
  reducers: {
    toggleNavbar: (state) => {
      state.value = !state.value;
    },
  },
});

export const { toggleNavbar } = navbarSlice.actions;
