/*
 Violet - A program for editing UML diagrams.

 Copyright (C) 2007 Cay S. Horstmann (http://horstmann.com)
 Alexandre de Pellegrin (http://alexdp.free.fr);

 This program is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.horstmann.violet.application.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.ErrorManager;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.horstmann.violet.application.gui.MainFrame;
import com.horstmann.violet.application.help.AboutDialog;
import com.horstmann.violet.application.help.HelpManager;
import com.horstmann.violet.application.help.ShortcutDialog;
import com.horstmann.violet.framework.injection.resources.ResourceBundleInjector;
import com.horstmann.violet.framework.injection.resources.annotation.ResourceBundleBean;
import com.horstmann.violet.workspace.IWorkspace;
import com.horstmann.violet.workspace.editorpart.IEditorPart;
import com.horstmann.violet.workspace.editorpart.IEditorPartBehaviorManager;
import com.horstmann.violet.workspace.editorpart.behavior.UndoRedoCompoundBehavior;

/**
 * Help menu
 * 
 * @author Alexandre de Pellegrin
 * 
 */
@ResourceBundleBean(resourceReference = MenuFactory.class)
public class SCMProjectMenu extends JMenu
{

    /**
     * Default constructor
     * 
     * @param mainFrame where this menu is atatched
     * @param factory to access to external resources such as texts, icons
     */
    @ResourceBundleBean(key = "SCMProject")
    public SCMProjectMenu(MainFrame mainFrame)
    {
        ResourceBundleInjector.getInjector().inject(this);
        this.mainFrame = mainFrame;
        this.createMenu();
    }

    /**
     * Initializes menu
     */
    private void createMenu()
    {

    	Feature1Item.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	HelpManager.getInstance().openHomepage();
            }

        });
        this.add(Feature1Item);

        Feature2Item.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                HelpManager.getInstance().openHomepage();
            }

        });
        this.add(Feature2Item);
        
        Feature3Item.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                AboutDialog dialog = new AboutDialog(mainFrame);
                dialog.setVisible(true);
            }

        });
        this.add(Feature3Item);

    }

    private boolean isThereAnyWorkspaceDisplayed()
    {
        return mainFrame.getWorkspaceList().size() > 0;
    }
    
    private IEditorPart getActiveEditorPart()
    {
        return this.mainFrame.getActiveWorkspace().getEditorPart();
    }

    /**
     * Main app frame where this menu is attached to
     */
    private MainFrame mainFrame;
    
    @ResourceBundleBean(key = "SCMProject.Feature1")
    private JMenuItem Feature1Item;
    
    @ResourceBundleBean(key = "SCMProject.Feature2")
    private JMenuItem Feature2Item;
    
    @ResourceBundleBean(key = "SCMProject.Feature3")
    private JMenuItem Feature3Item;




}
