
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %><html>
<html lang="en">
<head>
 </head>
<style>


h1 {
    font: 600 1.5em/1 rockwell;
    font-style:rockwell;
    color: rgba(0,0,0,.5);
    text-align: center;
    text-transform: uppercase;
    letter-spacing: .3em;
    position: absolute;
    top: 5%;
    width: 100%;
}
span, span:after {
    font-weight: 500;
    color:#696969;
    white-space: nowrap;
    display: inline-block;
    position: relative;
    letter-spacing: .1em;
    padding: .2em 0 .25em 0;
    font-family:Impact, Charcoal, sans-serif
}

span {
    font-size: 5.5em;
    z-index: 100;
    text-shadow: .04em .04em 0 #9cb8b3;
}

span:after {
    content: attr(data-shadow-text);
    color: rgba(0,0,0,.35);
    text-shadow: rockwell;
    position: absolute;
    left: .1em;
    top: .0875em;
    z-index: -1;
    -webkit-mask-image: url(https://f.cl.ly/items/1t1C0W3y040g1J172r3h/mask.png);
}


/* carousel */
.media-carousel 
{
  margin-bottom: 0;
  padding: 0 40px 30px 40px;
  margin-top: 30px;
}
/* Previous button  */
.media-carousel .carousel-control.left 
{
  left: -12px;
  background-image: none;
  background: none repeat scroll 0 0 #222222;
  border: 4px solid #FFFFFF;
  border-radius: 23px 23px 23px 23px;
  height: 40px;
  width : 40px;
  margin-top: 30px
}
/* Next button  */
.media-carousel .carousel-control.right 
{
  right: -12px !important;
  background-image: none;
  background: none repeat scroll 0 0 #222222;
  border: 4px solid #FFFFFF;
  border-radius: 23px 23px 23px 23px;
  height: 40px;
  width : 40px;
  margin-top: 30px
}
/* Changes the position of the indicators */
.media-carousel .carousel-indicators 
{
  right: 50%;
  top: auto;
  bottom: 0px;
  margin-right: -19px;
}
/* Changes the colour of the indicators */
.media-carousel .carousel-indicators li 
{
  background: #c0c0c0;
}
.media-carousel .carousel-indicators .active 
{
  background: #333333;
}
.media-carousel img
{
  width: 250px;
  height: 100px
}
/* End carousel */









</style> 
<body>
<jsp:include page="header.jsp"/>
 
 <security:authorize access="hasRole('ROLE_ADMIN')">
 <jsp:forward page="/adminHome"></jsp:forward>
 
 </security:authorize>
 <img src="resources/images/123.png" alt="123" style="width:200px;height:150px;"   align="left">
 
 
<span data-shadow-text="Text-Shadow">JUST ONE MORE CHAPTER</span><br> 



<script type="text/javascript">

$(document).ready(function() {
	  $('#media').carousel({
	    pause: true,
	    	  });
	});
</script>


  <div class='row'>
    <div class='col-md-8'>
      <div class="carousel slide " id="media" data-ride="carousel">
       <ol class="carousel-indicators">
    <li data-target="#media" data-slide-to="0" class="active"></li>
    <li data-target="#media" data-slide-to="1"></li>
    <li data-target="#media" data-slide-to="2"></li>
  </ol>
        <div class="carousel-inner">
          <div class="item  active">
            <div class="row">
              <div class="col-md-4">
	
                <a class="thumbnail" href="#"><img alt="1" src="resources/images/1.jpg"></a>
              </div>          
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="2" src="resources/images/2.jpg"></a>
              </div>
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="3" src="resources/images/3.jpg"></a>
              </div>        
            </div>
          </div>
          <div class="item">
            <div class="row">
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="5" src="resources/images/5.jpg"></a>
              </div>          
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="6" src="resources/images/6.jpg"></a>
              </div>
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="4" src="resources/images/4.jpg"></a>
              </div>        
            </div>
          </div>
          <div class="item">
            <div class="row">
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="" src="http://placehold.it/150x150"></a>
              </div>          
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="" src="http://placehold.it/150x150"></a>
              </div>
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="" src="http://placehold.it/150x150"></a>
              </div>      
            </div>
          </div>
        </div>
         <a class="left carousel-control" href="#media" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#media" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
       
      </div>                          
    </div>
  </div>

<a href="adminCategoryAdd">category</a>
<a href="adminProductAdd">products</a>
<a href="SupplierAdd">supplier</a>
 <a href="Login">login</a>a
 <a href="signup">signup</a>

 



</body>
</html>
