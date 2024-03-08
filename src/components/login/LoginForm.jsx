import { useFormik } from "formik";
import * as Yup from "yup";
import "./loginForm.css";

import VisibilityIcon from '@mui/icons-material/Visibility';
import VisibilityOffIcon from '@mui/icons-material/VisibilityOff';

import { useState } from 'react';
//import { IconButton, InputAdornment } from '@mui/material';

const LoginForm = () => {

    //duy tri trang thai mat khau mac dinh
    const [showPassword, setShowPassword] = useState(false);


    const formik = useFormik({
        initialValues: {
            phone: "",
            password: "",

        },
        validationSchema: Yup.object({

            password: Yup.string()
                .required("Mật khẩu không được bỏ trống")
                .matches(
                    /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d][A-Za-z\d!@#$%^&*()_+]{8,16}$/,
                    "Mật khẩu có 8 đến 16 ký tự, bao gồm ký tự thường, hoa, số và ký tự đặc biệt."
                ),

            phone: Yup.string()
                .required("Số điện thoại không được bỏ trống")
                .matches(
                    /(84|0[3|5|7|8|9])+([0-9]{8})\b/,
                    "Số điện thoại phải  hợp lệ (có 10 số)."
                ),
        }),
        onSubmit: (values) => {
            //window.alert("Form submitted");
            console.log(values);

        },
    });

    return (
        <section>
            <form className="infoform" onSubmit={formik.handleSubmit}>

                <label> Số điện thoại </label>

                <input
                    type="text"
                    id="phone"
                    name="phone"
                    value={formik.values.phone}
                    onChange={formik.handleChange}
                    placeholder="Nhập số điện thoại"
                />
                {formik.errors.phone && (
                    <p className="errorMsg"> {formik.errors.phone} </p>
                )}

                <label> Mật khẩu </label>
                <div className="pass">
                    <input
                        type={showPassword ? "text" : "password"}
                        id="password"
                        name="password"
                        value={formik.values.password}
                        onChange={formik.handleChange}
                        placeholder="Nhập mật khẩu"
                    />

                    <div className="icon" onClick={() => {
                        setShowPassword(!showPassword);
                    }}>
                        {showPassword ? <VisibilityIcon /> : <VisibilityOffIcon />}

                    </div>
                </div>

                {formik.errors.password && (
                    <p className="errorMsg"> {formik.errors.password} </p>
                )}
                <button type="submit"> Đăng nhập </button>
            </form>
        </section>
    );
};

export default LoginForm;
