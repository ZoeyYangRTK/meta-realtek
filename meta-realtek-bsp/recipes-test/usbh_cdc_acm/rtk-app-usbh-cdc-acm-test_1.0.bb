SUMMARY = "Usbh cdc acm Test for Realtek Ameba"
DESCRIPTION = "Usbh cdc acm Test for Realtek Ameba"
SECTION = "test"
HOMEPAGE = ""
LICENSE = "CLOSED"

inherit externalsrc

EXTERNALSRC = "${RTKDIR}/tests/usbh_cdc_acm"

EXTRA_OEMAKE = " \
    CROSS_COMPILE=${HOST_PREFIX} \
    -C ${S} O=${B} V=1\
"

CFLAGS +=" --sysroot=${STAGING_DIR_HOST}"
LDFLAGS += "${TUNE_CCARGS}"

do_compile() {
    oe_runmake all
}

do_install () {
    install -d ${D}${base_bindir}
    install ${B}/rtk_usbh_cdc_acm_test ${D}${base_bindir}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
