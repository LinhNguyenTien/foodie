
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";

import "../../css/mngtForm.css";

import { useState } from "react";
import { productInputs } from "../../data/dataFormProductMngt";

const EditProduct = ({ title }) => {
    const [inputs] = useState(productInputs);
    return (
        <div className="new">
            <Sidebar />
            <div className="newContainer">
                <Navbar />
                <div className="title top">
                    <h1>{title}</h1>
                </div>
                <div className="bottom">
                    <div className="column">
                        <form  >
                            {inputs.map((input) => (
                                <div className="formInput" key={input.id}>
                                    <label>{input.label}</label>
                                    <input type={input.type} value={input.value} />

                                </div>
                            ))}
                            <button type="submit"> Cập nhật </button>
                        </form>
                    </div>

                </div>
            </div>
        </div>

    );
};

export default EditProduct;
