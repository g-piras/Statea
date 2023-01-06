import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  value: false,
};

export const sidebarSlice = createSlice({
  name: "sidebar",
  initialState,
  reducers: {
    toggleSidebar: (state) => {
      state.value = !state.value;
    },
  },
});

export const { toggleSidebar } = sidebarSlice.actions;
