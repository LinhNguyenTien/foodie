
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";

import "../../css/mngtForm.css";

import { useState } from "react";
import { productInputs } from "../../data/dataFormProductMngt";

const AddProduct = ({ title }) => {
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
                        <form>
                            {/* tải ảnh từ máy */}
                            {/* <div className="formInput">
                                <label htmlFor="file">
                                    Image: <DriveFolderUploadOutlinedIcon className="icon" />
                                </label>
                                <input
                                    type="file"
                                    id="file"
                                    onChange={(e) => setFile(e.target.files[0])}
                                    style={{ display: "none" }}
                                />
                            </div> */}

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

export default AddProduct;
