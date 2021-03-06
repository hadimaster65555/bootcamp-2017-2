/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimas.maryanto.universitas.controller;

import com.dimas.maryanto.universitas.dao.KelasDao;
import com.dimas.maryanto.universitas.model.Kelas;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dimmaryanto93
 */
@WebServlet(urlPatterns = {"/kelas/update"})
public class KelasUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        Kelas kelas = new Kelas();
        kelas.setId(Integer.valueOf(req.getParameter("id")));

        KelasDao kelasDao = new KelasDao();
        kelas = kelasDao.cariKelasDenganId(kelas.getId());

        req.setAttribute("k", kelas);
        req.getRequestDispatcher("/pages/kelas/updateKelas.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

        Kelas kelasBaru = new Kelas();
        kelasBaru.setId(Integer.valueOf(req.getParameter("kelasId")));
        kelasBaru.setNama(req.getParameter("kelasName"));
        kelasBaru.setAngkatan(Integer.valueOf(req.getParameter("kelasAngkatan")));

        KelasDao kelasDao = new KelasDao();
        kelasDao.update(kelasBaru);

        resp.sendRedirect(req.getServletContext().getContextPath() + "/kelas/list");
    }

}
