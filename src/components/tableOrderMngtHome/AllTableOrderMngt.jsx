import "../../css/mngtTableHome.css";


//
import { DataGrid } from '@mui/x-data-grid';

//data
import { allOrderMngtRows, orderMngtColumns } from "../../data/dataOrderMngtHome";

import { Link } from "react-router-dom";
import { useState } from "react";




const AllTableOrderMngt = () => {

    const [data] = useState(allOrderMngtRows);


    const actionColumn = [
        {
            field: "action",
            headerName: "",
            width: 150,
            renderCell: () => {
                return (
                    <div className="cellAction">
                        <Link to="/orderManagement/test" style={{ textDecoration: "none" }}>
                            <div className="viewButton">Xem chi tiết</div>
                        </Link>

                    </div>
                );
            },
        },
    ];

    return (
        <div className="datatable" >
            <DataGrid className="datagrid"
                rows={data}
                columns={orderMngtColumns.concat(actionColumn)}

                initialState={{
                    pagination: {
                        paginationModel: { page: 0, pageSize: 9 },
                    },
                }}
                pageSizeOptions={[9]}
                checkboxSelection
            />
        </div>
    )
}

export default AllTableOrderMngt