<%-- 
    Document   : index
    Created on : 19 oct. 2020, 11:23:42
    Author     : Edwin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PDF Form</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>       
        <div class="container">
            <div class="row justify-content-md-center pt-4 pb-4"><h3>Programatic PDF Form</h3></div>
            <form action="${pageContext.request.contextPath}/pdf">
                <div class="row justify-content-md-center">
                    <div class="form-group col-4">
                        <label>Full Name</label> <input class="form-control" type="text" name="fullName">
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <div class="form-group col-4">
                        <label>Account Number</label> <input class="form-control" type="text" name="accountNumber">
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <div class="form-group col-4">
                        <label>Withdrawals</label> <input class="form-control" type="text" name="withdrawals">
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <div class="form-group col-4">
                        <label>Deposits</label> <input class="form-control" type="text" name="deposits">
                    </div>
                </div>
                <div class="row justify-content-md-center">
                <button type="submit" class="btn btn-primary">Generate PDF</button>
                </div>

        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
