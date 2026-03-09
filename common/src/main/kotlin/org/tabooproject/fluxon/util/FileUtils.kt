package org.tabooproject.fluxon.util

import taboolib.common.platform.function.getDataFolder
import java.io.File

/**
 * 将脚本文件路径转换为脚本 ID
 * 规则：去除数据文件夹路径前缀、将路径分隔符替换为下划线、去除文件扩展名
 *
 * @return 脚本 ID
 */
fun File.toScriptId(): String {
    return path.substringAfter(getDataFolder().path)
        .substringBeforeLast('.')
        .replace("[/\\\\]".toRegex(), "_")
        .drop(1)
        .substringAfter('_')
}

/**
 * 在指定文件夹中查找匹配的脚本文件
 * 支持多种匹配方式：文件名（不带扩展名）、完整文件名、脚本 ID
 *
 * @param folder 要搜索的文件夹
 * @param filename 要查找的文件名
 * @return 匹配的脚本文件，未找到则返回 null
 */
fun findScriptFile(folder: File, filename: String): File? {
    return folder.walk().firstOrNull { file ->
        file.extension == "fs" && (
            file.nameWithoutExtension == filename ||
            file.name == filename ||
            file.toScriptId() == filename
        )
    }
}