

// import React from "react";

// const ClothTypeFilter = ({ clothTypes, onSelect }) => {
//   return (
//     <select
//       id="clothTypeSelect"
//       className="form-control"
//       onChange={(e) => onSelect(e.target.value)}
//     >
//       <option value="">All Cloth Types</option>
//       {clothTypes.map((clothType) => (
//         <option key={clothType.id} value={clothType.id}>
//           {clothType.name}
//         </option>
//       ))}
//     </select>
//   );
// };

// export default ClothTypeFilter;





import React from "react";

const ClothTypeFilter = ({ clothTypes, onSelect }) => {
  return (
    <select
      id="clothTypeSelect"
      className="form-control"
      onChange={(e) => onSelect(e.target.value)}
    >
      <option value="">All Cloth Types</option>
      {clothTypes.map((clothType) => (
        <option key={clothType.id} value={clothType.id}>
          {clothType.name}
        </option>
      ))}
    </select>
  );
};

export default ClothTypeFilter;
