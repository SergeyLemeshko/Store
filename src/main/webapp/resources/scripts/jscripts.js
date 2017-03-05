var selectedElement;
$('#categoryContainer a').click(function () {
	$('#brandContainer').empty();
	$('#itemRow').empty();
	$('#brandDescription').empty();
	
	        $.ajax({
	            type: "GET",
	            cache: false,
	            url: $(this).attr("data-ref"),
	            success: function (response) {
	            	var html = "";
	            	$.each(response.brands, function (i) {         
	                	html = html + '<a class="list-group-item" href=# data-ref="' + requestContextPath + '/category/' + response.category +'/brand/' 
	                	+ response.brands[i].id + '">' + response.brands[i].name + '&nbsp[' + response.brands[i].count + ']</a>';
	            
	                });
	            	$('#brandContainer').append(html);
	            	$('#brandContainer a').click(function() {
	            	    if (selectedElement != null)
	            	    	selectedElement.attr("class", "list-group-item");
	            	    selectedElement = $(this);
	            	    $(this).attr("class", "list-group-item active");
	            		$.ajax({
	            			type:"GET",
	 	            		cache:false,
	 	            		url:$(this).attr("data-ref"),
	 	            		success:function(resp) {
	 	            			$('#itemRow').empty();
	 	            			$('#brandDescription').empty();
	 	            			var itemsHtml="";
	 	            			$.each(resp.items, function(i) {
	 	            				itemsHtml = itemsHtml + '<div class="col-sm-6 col-md-3">' +
	 	            											'<a class="thumbnail" href=# data-toggle="modal" data-target="#myModal">' +
	 	            												'<img class="itemSmallImage" src="' + imagesPath + "/" + resp.items[i].image +'"   alt="...">' +
	 	            				 							      '<div class="caption">' +
	 	            				 							        '<h3>' + resp.items[i].name +'</h3>' +
	 	            				 							        '<p>' + resp.items[i].description + '</p>' +
	 	            				 							      '</div>' +
	 	            				 							    '</a>' +
	 	            				 							'</div>';
	 	            			});
	 	            			$('#itemRow').append(itemsHtml);
	 	            			$('#brandDescription').append('<div class="jumbotron"><p>' + resp.description + '</p></div>');
	 	            			$('#itemRow a').click(function(i) {
	 	            				$('#myModalLabel').text($(this).find('h3').text());
	 	            				$('#myModalImage').attr('src',$(this).find('img').attr('src'));
	 	            			});
	 	            		} 
	            		 });
	            	});
	           }
	        });
	    });