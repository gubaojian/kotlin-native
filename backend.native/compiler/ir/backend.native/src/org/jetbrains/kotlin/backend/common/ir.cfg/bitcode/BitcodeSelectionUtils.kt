package org.jetbrains.kotlin.backend.common.ir.cfg.bitcode

import llvm.LLVMConstBitCast
import llvm.LLVMTargetDataRef
import llvm.LLVMValueRef
import org.jetbrains.kotlin.backend.common.ir.cfg.Function
import org.jetbrains.kotlin.backend.common.ir.cfg.FunctionMetaInfo
import org.jetbrains.kotlin.backend.common.ir.cfg.Klass
import org.jetbrains.kotlin.backend.common.ir.cfg.KlassMetaInfo
import org.jetbrains.kotlin.backend.konan.Context
import org.jetbrains.kotlin.backend.konan.descriptors.isAbstract
import org.jetbrains.kotlin.backend.konan.descriptors.isIntrinsic
import org.jetbrains.kotlin.backend.konan.llvm.*
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.FunctionDescriptor

internal interface BitcodeSelectionUtils: ContextUtils {

    val Klass.isExternal: Boolean
            get() = context.cfgDeclarations.classMetas[this]!!.isExternal

    val Function.llvmFunction: LLVMValueRef
        get() = context.cfgLlvmDeclarations.functions[this]?.llvmFunction
                ?: error("$this is undeclared for reason unknown")

    /**
     * Address of entry point of [llvmFunction].
     */
    val Function.entryPointAddress: ConstValue
        get() {
            val result = LLVMConstBitCast(this.llvmFunction, int8TypePtr)!!
            return constValue(result)
        }


    val Klass.typeInfoPtr: ConstPointer
        get() {
            return if (this.isExternal) {
                constPointer(importGlobal(this.typeInfoSymbolName, runtime.typeInfoType))
            } else {
                context.cfgLlvmDeclarations.classes[this]!!.typeInfo
            }
        }
}