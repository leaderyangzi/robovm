/*
 * Copyright (C) 2011 The NullVM Open Source Project
 *
 * TODO: Insert proper license header.
 */
package org.nullvm.ide.internal;

import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.nullvm.ide.NullVMPlugin;

/**
 *
 * @version $Id$
 */
public class NullVMClasspathContainer implements IClasspathContainer {

    public static final String ID = "org.nullvm.ide.NULLVM_CONTAINER";
    public static final IPath PATH = new Path(ID);
    
    public IClasspathEntry[] getClasspathEntries() {
        File nullVMHomeDir = NullVMPlugin.useBundledNullVM() 
                ? NullVMPlugin.getBundledNullVMDir() 
                        : NullVMPlugin.getNullVMHomeDir();
        File f = new File(new File(nullVMHomeDir, "lib"), "nullvm-rt.jar");
        return new IClasspathEntry[] {
            JavaCore.newLibraryEntry(new Path(f.getAbsolutePath()), null, null)
        };
    }

    public String getDescription() {
        return "NullVM Runtime Library";
    }

    public int getKind() {
        return K_DEFAULT_SYSTEM;
    }

    public IPath getPath() {
        return PATH;
    }

}
