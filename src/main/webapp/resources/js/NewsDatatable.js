/**
 * Created by Анатолий on 09.06.2016.
 */
$(document).ready(function(){

    $('#newstable').find('tfoot th:nth-child(2)').html( '<input type="text" placeholder="Search" />' );

    $('#newstable').find('tfoot th:nth-child(4)').html( '<select>' +
            '<option>Политика</option>' +
            '<option>Экономика</option>' +
            '<option>Спорт</option>' +
            '</select>' );

    var table = $("#newstable").DataTable({

        "responsive":true,
        "autoWidth":false,
        "ajax":{
            "url":"ajax/news",
            "dataSrc":""
        },
        "columns":[
            {"data":"id"},
            {"data":"headline"},
            {
                "data":"date",
                "orderable":false,
                "defaultContent":"",
                "render":function(data, type, row){
                    return (new Date(data)).toString('dd.MM.yyyy')
                }
            },
            {
                "data":"categories",
                "orderable":false,
                "defaultContent":"",
                "render":function(data, type, row){
                    if (data.length>0) {var res=data[0].name;
                    for(var i=1;i<data.length;i++){
                        res+=', '+data[i].name
                    }
                    return res;}
                }
            },
            {
                "orderable":false,
                "defaultContent":"",
                "render":renderEditBtn
            },
            {
                "orderable":false,
                "defaultContent":"",
                "render":renderDeleteBtn
            },
            {
                "data":"content"
            }
        ]
        ,
        "initComplete": function(){
            makeEditable();
        }

    });


    table.columns().every( function () {
        var that = this;

        $( 'input', this.footer() ).on( 'keyup change', function () {
            console.log(that);
            if ( that.search() !== this.value ) {
                that
                    .search( this.value )
                    .draw();
            }
        } );

        $( 'select', this.footer() ).on( 'change', function () {
            if ( that.search() !== this.value ) {
                that
                    .search( this.value )
                    .draw();
            }
        } );

    } );

    $("#newstable_filter").find("label").html("Поиск по содержанию: <input type='search' class='form-control input-sm' placeholder='' aria-controls='newstable'>")
    $("#newstable_filter").find("input").on('keyup change', function(){
        var content_cal=table.column(6);
        if (content_cal.search()!==this.value){
            content_cal
                .search( this.value )
                .draw();
        }
    })




});