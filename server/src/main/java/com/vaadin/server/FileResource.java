/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.vaadin.util.FileTypeResolver;

/**
 * <code>FileResources</code> are files or directories on local filesystem. The
 * files and directories are served through URI:s to the client terminal and
 * thus must be registered to an URI context before they can be used. The
 * resource is automatically registered to the application when it is created.
 *
 * @author Vaadin Ltd.
 * @since 3.0
 */
@SuppressWarnings("serial")
public class FileResource implements ConnectorResource {

    /**
     * Default buffer size for this stream resource.
     */
    private int bufferSize = 0;

    /**
     * File where the downloaded content is fetched from.
     */
    private File sourceFile;

    /**
     * Default cache time for this stream resource.
     */
    private long cacheTime = DownloadStream.DEFAULT_CACHETIME;

    /**
     * Creates a new file resource for providing given file for client
     * terminals.
     *
     * @param sourceFile
     *            the file that should be served.
     */
    public FileResource(File sourceFile) {
        if (sourceFile == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        setSourceFile(sourceFile);
    }

    @Override
    public DownloadStream getStream() {
        try {
            final DownloadStream ds = new DownloadStream(
                    new FileInputStream(sourceFile), getMIMEType(),
                    getFilename());
            ds.setParameter("Content-Length",
                    String.valueOf(sourceFile.length()));

            ds.setCacheTime(cacheTime);
            return ds;
        } catch (final FileNotFoundException e) {
            throw new RuntimeException(
                    "File not found: " + sourceFile.getName(), e);
        }
    }

    /**
     * Gets the source file.
     *
     * @return the source File.
     */
    public File getSourceFile() {
        return sourceFile;
    }

    /**
     * Sets the source file.
     *
     * @param sourceFile
     *            the source file to set.
     */
    private void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    public String getFilename() {
        return sourceFile.getName();
    }

    @Override
    public String getMIMEType() {
        return FileTypeResolver.getMIMEType(sourceFile);
    }

    /**
     * Gets the length of cache expiration time. This gives the adapter the
     * possibility cache streams sent to the client. The caching may be made in
     * adapter or at the client if the client supports caching. Default is
     * <code>DownloadStream.DEFAULT_CACHETIME</code>.
     *
     * @return Cache time in milliseconds.
     */
    public long getCacheTime() {
        return cacheTime;
    }

    /**
     * Sets the length of cache expiration time. This gives the adapter the
     * possibility cache streams sent to the client. The caching may be made in
     * adapter or at the client if the client supports caching. Zero or negavive
     * value disbales the caching of this stream.
     *
     * @param cacheTime
     *            the cache time in milliseconds.
     */
    public void setCacheTime(long cacheTime) {
        this.cacheTime = cacheTime;
    }

    /**
     * Gets the size of the download buffer used for this resource.
     *
     * <p>
     * If the buffer size is 0, the buffer size is decided by the terminal
     * adapter. The default value is 0.
     * </p>
     *
     * @return the size of the buffer in bytes.
     */
    public int getBufferSize() {
        return bufferSize;
    }

    /**
     * Sets the size of the download buffer used for this resource.
     *
     * @param bufferSize
     *            the size of the buffer in bytes.
     */
    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }
}
