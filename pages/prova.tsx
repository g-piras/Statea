import React, { useState } from "react";

const prova = () => {
  const [checked, setChecked] = useState("first-checkbox");

  return (
    <div className="mt-[400px]">
      <div className="tabs">
        <a className="tab tab-lifted">Tab 1</a>
        <a className="tab tab-lifted tab-active">Tab 2</a>
        <a className="tab tab-lifted">Tab 3</a>
      </div>
    </div>
  );
};

export default prova;
