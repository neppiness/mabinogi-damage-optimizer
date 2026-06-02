import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import path from 'path'
import fs from 'fs'

const fontFiles = ['Pretendard-Regular.subset.woff2', 'Pretendard-SemiBold.subset.woff2']
const fontsSource = path.resolve(__dirname, '../web/static/woff2-subset')

function pretendardFontsPlugin() {
  return {
    name: 'pretendard-fonts',
    configureServer(server: any) {
      server.middlewares.use('/fonts', (req: any, res: any, next: any) => {
        const filename = req.url?.slice(1)
        if (filename && fontFiles.includes(filename)) {
          res.setHeader('Content-Type', 'font/woff2')
          fs.createReadStream(path.join(fontsSource, filename)).pipe(res)
        } else {
          next()
        }
      })
    },
    closeBundle() {
      const outDir = path.resolve(__dirname, 'dist/fonts')
      fs.mkdirSync(outDir, { recursive: true })
      for (const file of fontFiles) {
        fs.copyFileSync(path.join(fontsSource, file), path.join(outDir, file))
      }
    },
  }
}

export default defineConfig({
  plugins: [react(), pretendardFontsPlugin()],
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
      },
    },
  },
})
