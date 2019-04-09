$(document).ready(function(){

// List all api request
$('#list-all').on('click', ()=>{
    getAllAssets('json-list-all');
});

$('#list-one').on('click', ()=>{
    getAssetById('json-list-one');
});


// Client API service functions
const getAllAssets = (element)=>{
    const URL = '/api/assets/';
    try{
        makeAjaxCall('GET', element, URL, null);
    }catch(e){ console.error(e.message); }
}


const getAssetById = (element)=>{
    const id = $('#endpoint-single').val().split('/').slice(-1);
    const URL = `/api/assets/${id}`;
     try{
         makeAjaxCall('GET', element, URL, null);
     }catch(e){ console.error(e.message) };
}


// Helper functions
const makeAjaxCall = (method, elementId, url, data) => {
        $.ajax({
          url: url,
          method: method,
          data: data,
          dataType: 'json',
          error: (err) => { console.log("Failed to fetch: ", err); },
          success: (response)=> { updateDom(response, elementId); },
        });
}

const updateDom = (data, element) => {
    const jsonContainer = document.getElementById(element);
    console.log('Data,', Array.from(data));

    const apiResponse = Array.from(data);

    jsonContainer.innerText = "";
    jsonContainer.innerHTML = "";
    apiResponse.map( obj => {
       jsonContainer.innerHTML += `<span> ${JSON.stringify(obj)}</span><br>` ;
    });

    if( apiResponse.length === 0 && data !== null)   jsonContainer.innerHTML += JSON.stringify(data);
}


});


