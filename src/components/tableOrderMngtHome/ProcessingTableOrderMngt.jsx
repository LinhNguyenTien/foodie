import "../../css/mngtTableHome.css";

import { DataGrid } from '@mui/x-data-grid';
//data
import { orderMngtColumns, processingOrderMngtRows } from "../../data/dataOrderMngtHome";

import { Link } from "react-router-dom";
import { useState } from "react";

const ProcessingTableOrderMngt = () => {
    const [data] = useState(processingOrderMngtRows);
    //const [data, setData] = useState(processingOrderMngtRows);


    // const handleBlock = (id) => {
    //     setData(data.filter((item) => item.id !== id));
    // };
    const actionColumn = [
        {
            field: "action",
            headerName: "",
            width: 180,
            renderCell: (params) => {
                return (
                    <div className="cellAction">
                        <Link to="/orderManagement/test" style={{ textDecoration: "none" }}>
                            <div className="viewButton">Xem chi tiết</div>
                        </Link>
                        <div
                            className="activeButton"
                        //onClick={() => handleBlock(params.row.id)}
                        >
                            Duyệt
                        </div>

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

export default ProcessingTableOrderMngt