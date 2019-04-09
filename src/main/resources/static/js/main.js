$(document).ready(function () {

    // List all api request
    $('#list-all').on('click', () => {
        getAllAssets('json-list-all');
    });

    $('#list-one').on('click', () => {
        getAssetById('json-list-one');
    });

    $('#create-btn').on('click', () => {
        createAsset('json-create');
    });

    $('#update-btn').on('click', () => {
        updateAsset('json-update');
    });

    $('#delete-btn').on('click', () => {
        deleteAsset('json-delete');
    });


    // Client API service functions
    const getAllAssets = (element) => {
        const URL = '/api/assets/';
        try {
            makeAjaxCall('GET', element, URL, null);
        } catch (e) { console.error(e.message); }
    }


    const getAssetById = (element) => {
        const id = $('#endpoint-single').val().split('/').slice(-1);
        const URL = `/api/assets/${id}`;
        try {
            makeAjaxCall('GET', element, URL, null);
        } catch (e) { console.error(e.message) };
    }

    const createAsset = (element)=>{
        const URL = `/api/add/`;
        const data = {
            id: null,
            name: $('#asset-name').val(),
            description: $('#asset-descr').val(),
            state: $('#asset-state').val(),
            owner: null,
        };

        console.log('Data object: ', data);

        try {
            makeAjaxCall('POST', element, URL, data);
        } catch (e) { console.error(e.message) };
    }

    const updateAsset = (element)=>{
        const id = $('#endpoint-update').val().split('/').slice(-1);
        const URL = `/api/update/${id}`;
        const data = {
            id: null,
            name: $('#asset-name1').val(),
            description: $('#asset-descr1').val(),
            state: $('#asset-state').val(),
            owner: null,
        };

        try {
            makeAjaxCall('PATCH', element, URL, data);
        } catch (e) { console.error(e.message) };
    }

    const deleteAsset = (element)=>{
        const id = $('#endpoint-delete').val().split('/').slice(-1);
        const URL = `/api/delete/${id}`;

        try {
            makeAjaxCall('DELETE', element, URL, null);
        } catch (e) { console.error(e.message) };
    }


    // Helper functions
    const makeAjaxCall = (method, elementId, url, data) => {
        $.ajax({
            url: url,
            method: method,
            data: JSON.parse(data),
            dataType: 'json',
            contentType:'application/json',
            error: (err) => { console.log("Ajax failed to make api request: ", err); },
            success: (response) => { 
                updateDom(response, elementId); 
            },
        });
    }

    const updateDom = (data, element) => {
        if(!data) return;
        const jsonContainer = document.getElementById(element);
        console.log('Data,', Array.from(data));

        const apiResponse = Array.from(data);

        jsonContainer.innerText = "";
        jsonContainer.innerHTML = "";
        apiResponse.map(obj => {
            jsonContainer.innerHTML += `<span> ${JSON.stringify(obj)}</span><br>`;
        });

        if (apiResponse.length === 0 && data !== null) jsonContainer.innerHTML += JSON.stringify(data);
    }


});


