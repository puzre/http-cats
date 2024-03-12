package com.puzre.httpcats.data

object HttpCodesRepository {

    fun getAllCodes() = arrayOf(
        arrayOf(
            HttpCode("100", "Continue"),
            HttpCode("101", "Switching Protocols"),
            HttpCode("102", "Processing"),
            HttpCode("103", "Early Hints")
        ),
        arrayOf(
            HttpCode("200", "OK"),
            HttpCode("201", "Created"),
            HttpCode("202", "Accepted"),
            HttpCode("203", "Non-Authoritative Information"),
            HttpCode("204", "No Content"),
            HttpCode("206", "Partial Content"),
            HttpCode("205", "Reset Content"),
            HttpCode("207", "Multi-Status"),
            HttpCode("208", "Already Reported"),
            HttpCode("226", "IM Used")
        ),
        arrayOf(
            HttpCode("300", "Multiple Choices"),
            HttpCode("301", "Moved Permanently"),
            HttpCode("302", "Found"),
            HttpCode("303", "See Other"),
            HttpCode("304", "Not Modified"),
            HttpCode("305", "Use Proxy"),
            HttpCode("307", "Temporary Redirect"),
            HttpCode("308", "Permanent Redirect")
        ),
        arrayOf(
            HttpCode("400", "Bad Request"),
            HttpCode("401", "Unauthorized"),
            HttpCode("402", "Payment Required"),
            HttpCode("403", "Forbidden"),
            HttpCode("404", "Not Found"),
            HttpCode("405", "Method Not Allowed"),
            HttpCode("406", "Not Acceptable"),
            HttpCode("407", "Proxy Authentication Required"),
            HttpCode("408", "Request Timeout"),
            HttpCode("409", "Conflict"),
            HttpCode("410", "Gone"),
            HttpCode("411", "Length Required"),
            HttpCode("412", "Precondition Failed"),
            HttpCode("413", "Payload Too Large"),
            HttpCode("414", "Request-URI Too Long"),
            HttpCode("415", "Unsupported Media Type"),
            HttpCode("416", "Request Range Not Satisfiable"),
            HttpCode("417", "Expectation Failed"),
            HttpCode("418", "I’m a teapot"),
            HttpCode("420", "Enhance Your Calm"),
            HttpCode("421", "Misdirected Request"),
            HttpCode("422", "Unprocessable Entity"),
            HttpCode("423", "Locked"),
            HttpCode("424", "Failed Dependency"),
            HttpCode("425", "Too Early"),
            HttpCode("426", "Upgrade Required"),
            HttpCode("428", "Precondition Required"),
            HttpCode("429", "Too Many Requests"),
            HttpCode("431", "Request Header Fields Too Large"),
            HttpCode("444", "No Response"),
            HttpCode("450", "Blocked by Windows Parental Controls"),
            HttpCode("451", "Unavailable For Legal Reasons"),
            HttpCode("497", "HTTP Request Sent to HTTPS Port"),
            HttpCode("498", "Token expired/invalid"),
            HttpCode("499", "Client Closed Request")
        ),
        arrayOf(
            HttpCode("500", "Internal Server Error"),
            HttpCode("501", "Not Implemented"),
            HttpCode("502", "Bad Gateway"),
            HttpCode("503", "Service Unavailable"),
            HttpCode("504", "Gateway Timeout"),
            HttpCode("506", "Variant Also Negotiates"),
            HttpCode("507", "Insufficient Storage"),
            HttpCode("508", "Loop Detected"),
            HttpCode("509", "Bandwidth Limit Exceeded"),
            HttpCode("510", "Not Extended"),
            HttpCode("511", "Network Authentication Required"),
            HttpCode("521", "Web Server Is Down"),
            HttpCode("522", "Connection Timed Out"),
            HttpCode("523", "Origin Is Unreachable"),
            HttpCode("525", "SSL Handshake Failed"),
            HttpCode("530", "Site Frozen"),
            HttpCode("599", "Network Connect Timeout Error")
        )
    )

}