<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RentCar Pro - Admin Dashboard</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
    
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            overflow-x: hidden;
        }
        .wrapper {
            display: flex;
            width: 100%;
            align-items: stretch;
        }
        #sidebar {
            min-width: 260px;
            max-width: 260px;
            background: #1e293b; /* Dark Slate Modern */
            color: #fff;
            min-height: 100vh;
            transition: all 0.3s;
        }
        #sidebar .sidebar-header {
            padding: 20px;
            background: #0f172a;
        }
        #sidebar ul p {
            color: #64748b;
            padding: 10px 20px 5px 20px;
            font-size: 0.85rem;
            font-weight: bold;
            text-transform: uppercase;
            margin-bottom: 0;
        }
        #sidebar ul li a {
            padding: 12px 20px;
            font-size: 1rem;
            display: flex;
            align-items: center;
            color: #cbd5e1;
            text-decoration: none;
            transition: 0.2s;
        }
        #sidebar ul li a:hover, #sidebar ul li.active a {
            color: #fff;
            background: #334155;
            border-left: 4px solid #3b82f6; /* Blue indicator */
        }
        #sidebar ul li a i {
            margin-right: 15px;
            font-size: 1.2rem;
        }
        #content {
            width: 100%;
            padding: 25px;
            min-height: 100vh;
        }
        .navbar-custom {
            background-color: #fff;
            box-shadow: 0 1px 3px rgba(0,0,0,0.05);
            border-radius: 10px;
            padding: 12px 20px;
            margin-bottom: 25px;
        }
        .card-custom {
            border: none;
            border-radius: 12px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.02);
        }
    </style>
</head>
<body>

<div class="wrapper">