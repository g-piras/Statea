import { configureStore } from "@reduxjs/toolkit";
import { navbarSlice } from "./NavbarSlice";
import { sidebarSlice } from "./SidebarSlice";

export const store = configureStore({
  reducer: {
    navbar: navbarSlice.reducer,
    sidebar: sidebarSlice.reducer,
  },
});

// Infer the `RootState` and `AppDispatch` types from the store itself
export type RootState = ReturnType<typeof store.getState>;
// Inferred type: {posts: PostsState, comments: CommentsState, users: UsersState}
export type AppDispatch = typeof store.dispatch;
