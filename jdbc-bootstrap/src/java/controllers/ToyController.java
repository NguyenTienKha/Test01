/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.Brand;
import db.BrandFacade;
import db.Toy;
import db.ToyFacade;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PHT
 */
@WebServlet(name = "ToyController", urlPatterns = {"/toy"})
public class ToyController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");
        String layout = (String) request.getAttribute("layout");

        ToyFacade tf = new ToyFacade();
        switch (action) {
            case "list":
                list(request, response);
                break;
            case "create":
                //Hien thi form Create
                create(request, response);
                break;
            case "create_handler":
                //Xu ly form Create
                create_handler(request, response);
                break;
            case "edit":
                //Hien thi form Confirm
                edit(request, response);
                break;
            case "edit_handler":
                //Xu ly form 
                edit_handler(request, response);
                break;
            case "delete":
                //Hien thi form Create
                delete(request, response);
                break;
            case "delete_handler":
                //Xu ly form Create
                delete_handler(request, response);
                break;
        }

    }

    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String layout = (String) request.getAttribute("layout");
        ToyFacade tf = new ToyFacade();
        try {
            List<Toy> list = tf.select();
            request.setAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();//in chi tiet ngoai le
            //request.setAttribute("errorMsg", e.getMessage());
            request.setAttribute("errorMsg", e.toString());
        }
        request.getRequestDispatcher(layout).forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String layout = (String) request.getAttribute("layout");
        try {
            BrandFacade bf = new BrandFacade();
            List<Brand> list = bf.select();
            request.setAttribute("list", list); // truyen list cho view de tao combobox
        } catch (Exception e) {
            e.printStackTrace();//in chi tiet ngoai le
            request.setAttribute("errorMsg", "Can't read the Brand table !");
        }
        request.getRequestDispatcher(layout).forward(request, response);
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String layout = (String) request.getAttribute("layout");
        ToyFacade tf = new ToyFacade();
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date expDate = new Date(sdf.parse(request.getParameter("expDate")).getTime());
            String brand = request.getParameter("brand");
            //Tạo đối tượng toy
            Toy toy = new Toy();
            toy.setId(id);
            toy.setName(name);
            toy.setPrice(price);
            toy.setExpDate(expDate);
            toy.setBrand(brand);
            //Doc table brnad de de phong khi bi ngoai le
            BrandFacade bf = new BrandFacade();
            List<Brand> list = bf.select();
            request.setAttribute("list", list); // truyen list cho view de tao combobox
            //Lưu toy vào db
            tf.create(toy);
            //Quay vể trang toy/list.do
            request.getRequestDispatcher("/toy/list.do").forward(request, response);
//                    response.sendRedirect(request.getContextPath() + "/toy/list.do");
        } catch (Exception e) {
            e.printStackTrace();//in chi tiet ngoai le
            request.setAttribute("errorMsg", "Can't save toy into the db !");
            //chuyen ve trang create neu xay re exception
            request.setAttribute("action", "create");
        }
        request.getRequestDispatcher(layout).forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String layout = (String) request.getAttribute("layout");
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.getRequestDispatcher(layout).forward(request, response);
    }

    protected void delete_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String layout = (String) request.getAttribute("layout");
        ToyFacade tf = new ToyFacade();
        try {
            String id = request.getParameter("id");
            String op = request.getParameter("op");
            switch (op) {
                case "Yes":
                    tf.delete(id);
                    break;
                case "No":
                    break;
            }
            //Quay vể trang toy/list.do
//            request.getRequestDispatcher("/toy/list.do").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/toy/list.do");//che dau dia chi va khong send request moi 
        } catch (Exception e) {
            e.printStackTrace();//in chi tiet ngoai le
            request.setAttribute("errorMsg", "Can't delete toy into the db !");
            //chuyen ve trang list neu xay re exception
            request.setAttribute("action", "list");
            request.getRequestDispatcher(layout).forward(request, response);
        }

    }

    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String layout = (String) request.getAttribute("layout");
        ToyFacade tf = new ToyFacade();
        try {
            String id = request.getParameter("id");
            Toy toy = tf.select(id);
            request.setAttribute("toy", toy);
            
            BrandFacade bf = new BrandFacade();
            List<Brand> list = bf.select();
            request.setAttribute("list", list); // truyen list cho view de tao combobox
        } catch (Exception e) {
            e.printStackTrace();//in chi tiet ngoai le
            request.setAttribute("errorMsg", "Cant't read this toy from db !");

        }
        request.getRequestDispatcher(layout).forward(request, response);
    }

    protected void edit_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String layout = (String) request.getAttribute("layout");
        ToyFacade tf = new ToyFacade();
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date expDate = new Date(sdf.parse(request.getParameter("expDate")).getTime());
            String brand = request.getParameter("brand");
            
            BrandFacade bf = new BrandFacade();
            List<Brand> list = bf.select();
            request.setAttribute("list", list); // truyen list cho view de tao combobox
            
            //Tạo đối tượng toy
            Toy toy = new Toy();
            toy.setId(id);
            toy.setName(name);
            toy.setPrice(price);
            toy.setExpDate(expDate);
            toy.setBrand(brand);
            //Luu toy vao request de khi bi ngoai le thi hien lai thong tin da nhan
            request.setAttribute("toy", toy);
            //Lưu toy vào db
            tf.update(toy);
            //Quay vể trang toy/list.do
            response.sendRedirect(request.getContextPath() + "/toy/list.do");
        } catch (Exception e) {
            e.printStackTrace();//in chi tiet ngoai le
            request.setAttribute("errorMsg", "Can't edit toy into the db !");
            //chuyen ve trang edit neu xay re exception
            request.setAttribute("action", "edit");
            request.getRequestDispatcher(layout).forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
