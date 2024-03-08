
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";

import "../../css/mngtForm.css";


import { useState } from "react";
import { discountInputs } from "../../data/dataFormDiscountMngt";


const AddDiscount = ({ title }) => {
    const [inputs] = useState(discountInputs);
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
                        <form>
                            {inputs.map((input) => (
                                <div className="formInput" key={input.id}>
                                    <label>{input.label}</label>
                                    <input type={input.type} placeholder={input.placeholder} />
                                </div>
                            ))}
                            <button >Thêm</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>

    );
};

export default AddDiscount;
