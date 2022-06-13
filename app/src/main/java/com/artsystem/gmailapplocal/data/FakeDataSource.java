package com.artsystem.gmailapplocal.data;

import com.artsystem.gmailapplocal.R;
import com.artsystem.gmailapplocal.maillist.MailCategoryItem;
import com.artsystem.gmailapplocal.maillist.MailItem;
import com.artsystem.gmailapplocal.maillist.MailSimpleItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FakeDataSource {


    // Dummy Titles

    public static final String TITLE_1 ="Edurila.com";
    public static final String TITLE_2 ="Chris Abad";
    public static final String TITLE_3 ="Tuto.com";
    public static final String TITLE_4 ="support";
    public static final String TITLE_5 ="Matt from Ionic";

    // Dummy User Images

    public static final int IMG_1 = R.drawable.usernoimg0;
    public static final int IMG_2 = R.drawable.usernoimg;
    public static final int IMG_3 = R.drawable.usernoimg01;
    public static final int IMG_4 = R.drawable.usernoimg;
    public static final int IMG_5 = R.drawable.usernoimg0;


    // Dummy Mail Content
    public static final String Content_1 = "";

    // Dummy Description
    public static final String DESC_1 = "$19 Only (First 10 spots) - Bestselling...\nAre you looking to Learn Web Designing...";
    public static final String DESC_2 = "Help make Campaign Monitor better\nLet use know your thoughts! No Images...";
    public static final String DESC_3 = "8h de formation gratuite et les nouvea ...\nPhotoshop, SEO, Blender, CSS, WordPre...";
    public static final String DESC_4 = "Societe Ovh : suivi de vos services - hp ...\nSAS OVH - http://www.ovh.com 2 rue K ...";
    public static final String DESC_5 = "The New Ionic Creator Is Here!\nAnnouncing the all-new Creator, build";






    public static List<MailItem> getListMail(){

        List<MailItem> data = new ArrayList<>();


        data.add(new MailItem(new MailSimpleItem(
                1,
                TITLE_1,
                DESC_1,
                IMG_1,
                Content_1,
                true
        )));

        data.add(new MailItem(new MailSimpleItem(
                2,
                TITLE_2,
                DESC_2,
                R.drawable.c_test,
                Content_1
        )));

        data.add(new MailItem(new MailSimpleItem(
                3,
                TITLE_3,
                DESC_3,
                R.drawable.t_tets,
                Content_1
        )));

        data.add(new MailItem(new MailSimpleItem(
                4,
                TITLE_4,
                DESC_4,
                R.drawable.usernoimg,
                Content_1
        )));

        data.add(new MailItem(new MailSimpleItem(
                5,
                TITLE_5,
                DESC_5,
                R.drawable.m_test,
                Content_1
        )));



        return data;
    }


}
