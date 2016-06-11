/**
 * Created by Анатолий on 12.05.2016.
 */
var form;
function makeEditable(){
    form=$("#detailsForm");
}

function add() {
    clearForm();
    $('#editRow').modal();
}

function updateRow(id){
    $.ajax({
        "url":"ajax/get/"+id,
        "type":"GET",
        "success":function(data){
            clearForm();
            form.find("#id").val(data.id);
            form.find("#headline").val(data.headline);
            form.find("#content").val(data.content);
            $.each(data.categories, function(key, value){
                    form.find("#catIDs option[value='"+value.id+"']").prop("selected", "selected");
            });
            $('#editRow').modal();
        }
    });
}

function deleteRow(id){
    $.ajax({
        "url":"ajax/delete/"+id,
        "type":"DELETE",
        "success":function(){
            window.location.reload();
        }
    })
}

function renderEditBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="updateRow(' + row.id + ');">Edit</a>';
    }
    return data;
}

function renderDeleteBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-danger" onclick="deleteRow(' + row.id + ');">Delete</a>';
    }
    return data;
}


function clearForm(){
    form.find("input, textarea").val("");
    $('#id').val(0);
    form.find("option:selected").each(function(ind, opt){
        $(opt).prop("selected", false);
    })
}