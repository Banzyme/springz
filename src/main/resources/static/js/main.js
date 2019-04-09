$(document).ready(function(){

// List all api request
$('#list-all').on('click', ()=>{
    getAllAssets('json-list-all') ;
});




// Helper functions
const getAllAssets = (element)=>{

    $.ajax({
      url: '/api/assets',
      data: null,
      dataType: 'json',
      error: (err) => { console.log("Failed to fetch: ", err); },
      success: (response)=> { updateDom(response, element); },
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
}


const formatAjaxResult = (data) => {
    return data;
}

});


